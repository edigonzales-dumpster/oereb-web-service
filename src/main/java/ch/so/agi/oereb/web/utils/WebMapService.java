package ch.so.agi.oereb.web.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

@Service
public class WebMapService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final double INCH_MM = 25.4;
	private static final int SRS = 2056;
		
	private String wmsBbox;
	private double wmsWidth;
	private double wmsHeight;
	private String outputFormat = "png";	
	
	private int dpi = 96; // TODO: Must be higher I guess!
	private double paperWidthMM = 174; // see "Weisung"
	private double paperHeightMM = 99; // see "Weisung"
	private double extractMapRatio = paperWidthMM / paperHeightMM; 
	private double bboxExpandScale = 1.1;
	
	/**
	 * Creates a GeoTools WebMapService object. If a getMap url is used, 
	 * it will try to convert it to a getCapabilities url.
	 * 
	 * @param WMS URL (GetMap or GetCapabilities)
	 */
	
	public byte[] getImage(String wmsUrl, Envelope parcelExtent) throws WebMapServiceException {
		// Do some math first: We need to calculate the WIDTH and HEIGHT and BBOX 
		// for the getMap request.
		calculateGetMapParameters(parcelExtent);
		
		// Now create the getMap request by copying and replacing (some) query parameters.
		String getMapRequest = createGetMapRequest(wmsUrl);
		
		log.info(getMapRequest);
		System.out.println(getMapRequest);
		
		// Request the image and return it as byte[], which is needed by JAXB.
		CloseableHttpClient httpclient = HttpClients.custom()
				.setRedirectStrategy(new LaxRedirectStrategy()) // adds HTTP REDIRECT support to GET and POST methods 
				.build();
		try {
			HttpGet get = new HttpGet(new URL(getMapRequest).toURI()); 
			CloseableHttpResponse response = httpclient.execute(get);
			InputStream inputStream = response.getEntity().getContent();
			BufferedImage image = ImageIO.read(inputStream);
			
			// Save image to local file system.
			// For debugging.
//			Path tmpDirectory = Files.createTempDirectory(Paths.get(System.getProperty("java.io.tmpdir")), "oereb");
//			Path outputfilePath = Paths.get(tmpDirectory.toString(), "image.png");
//			ImageIO.write(image, "png", outputfilePath.toFile());
//			log.info(outputfilePath.toString());

			// Save image as byte[]
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, outputFormat, baos); 
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		} finally {
			IOUtils.closeQuietly(httpclient);
		}
	}
	
	private void calculateGetMapParameters(Envelope parcelExtent) {
		wmsWidth = this.paperWidthMM / this.INCH_MM * dpi;
		wmsHeight = wmsWidth / extractMapRatio;

		double parcelExtentRatio = parcelExtent.getWidth() / parcelExtent.getHeight();
		double minX;
		double minY;
		double maxX;
		double maxY;
		double midpointX = parcelExtent.getMinX() + parcelExtent.getWidth()/2;
		double midpointY = parcelExtent.getMinY() + parcelExtent.getHeight()/2;

		log.info("parcelExtentRatio: " + String.valueOf(parcelExtentRatio));
		
		// TODO: TEST THIS CAREFULLY!!!!!!!!!!
		if (extractMapRatio < parcelExtentRatio) {
			minX = midpointX - parcelExtent.getWidth()/2;
			minY = midpointY - (parcelExtent.getWidth()/2 / extractMapRatio);
			
			maxX = midpointX + parcelExtent.getWidth()/2;
			maxY = midpointY + (parcelExtent.getWidth()/2 / extractMapRatio);
		} else {
			minX = midpointX - parcelExtent.getHeight()/2 * extractMapRatio;
			minY = midpointY - (parcelExtent.getHeight()/2 );
			
			maxX = midpointX + parcelExtent.getHeight()/2 * extractMapRatio;
			maxY = midpointY + (parcelExtent.getHeight()/2 );
		}
		
		// Must be the same as extractMapRatio.
		double l = maxX - minX;
		double h = maxY - minY;
		log.debug(String.valueOf("bboxRatio: " + l/h) + " -- extractMapRatio: " + extractMapRatio);
		
		// Expand bbox to get a better visual result.
		Envelope bboxEnvelope = new Envelope(new Coordinate(minX, minY), new Coordinate(maxX, maxY));
		double expandDistance = (bboxEnvelope.getMaxX() - bboxEnvelope.getMinX()) * bboxExpandScale - (bboxEnvelope.getMaxX() - bboxEnvelope.getMinX());
		bboxEnvelope.expandBy(expandDistance, expandDistance / extractMapRatio);
				
		wmsBbox = bboxEnvelope.getMinX() + "," + bboxEnvelope.getMinY() + "," + bboxEnvelope.getMaxX()  + "," + bboxEnvelope.getMaxY();
	}
	
	private String createGetMapRequest(String wmsUrl) throws WebMapServiceException {
		Charset charset = Charset.forName("UTF-8");
		List<org.apache.http.NameValuePair> params;
		URI getMapUri;
		try {
			getMapUri = new URI(wmsUrl);
			params = URLEncodedUtils.parse(getMapUri, charset);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		}
		
		String schema = getMapUri.getScheme();
		String host = getMapUri.getHost();
		String path = getMapUri.getPath();
		
		String port = "";
		if (getMapUri.getPort() > 0) {
			port = String.valueOf(getMapUri.getPort());
		}
				
		StringBuilder getMapRequestBuilder = new StringBuilder();
		getMapRequestBuilder.append(schema);
		getMapRequestBuilder.append("://");
		getMapRequestBuilder.append(host);
		getMapRequestBuilder.append(path);

		StringBuilder queryBuilder = new StringBuilder();
		int idx = 0;
		for (org.apache.http.NameValuePair param : params) {
			if (idx > 0) {
				queryBuilder.append("&");
			}
			if (param.getName().equalsIgnoreCase("SRS") || param.getName().equalsIgnoreCase("CRS")) {
				queryBuilder.append(param.getName()).append("=").append("EPSG:"+SRS);
			} else if (param.getName().equalsIgnoreCase("BBOX")) {
				queryBuilder.append(param.getName()).append("=").append(wmsBbox);
			} else if (param.getName().equalsIgnoreCase("WIDTH")) {
				queryBuilder.append(param.getName()).append("=").append(Double.valueOf(wmsWidth).intValue()); //TODO: QGIS server 1.8 cannot deal w/ doubles?
			} else if (param.getName().equalsIgnoreCase("HEIGHT")) {
				queryBuilder.append(param.getName()).append("=").append(Double.valueOf(wmsHeight).intValue());
			} else {
				if (param.getName().equalsIgnoreCase("FORMAT")) {
					String[] parts = param.getValue().split("/");
					outputFormat = parts[1].toLowerCase();
				}
				queryBuilder.append(param.getName()).append("=").append(param.getValue());
			}		
			idx++;
		}
	
		// QGIS server sucks... sorry. Not even URLEncoder.encode() works.
		// This has to better!!!!
		String queryString = queryBuilder.toString().replaceAll("/", "%2F").replaceAll(" ", "%20");
//		try {
//			queryString = URLEncoder.encode(queryBuilder.toString(), "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			throw new WebMapServiceException(e.getMessage());
//		}
		
		getMapRequestBuilder.append("?").append(queryString);
		
		return getMapRequestBuilder.toString();
	}	
}



