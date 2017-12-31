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
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
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
public class WebMapService implements InitializingBean {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;

	private static final double INCH_MM = 25.4;
	private static final int SRS = 2056;
		
	private String wmsBbox;
	private double wmsWidthPx;
	private double wmsHeightPx;
	private String outputFormat = "png";	
	
	private int dpi; 
	private double mapWidthMM;
	private double mapHeightMM;
	private double extractMapRatio; 
	private double mapBlowFactor;
	
	@Override
    public void afterPropertiesSet() throws Exception {
		dpi = Integer.valueOf(env.getProperty("oereb.extract.static.map.dpi", "96"));
		
		mapWidthMM = Double.valueOf(env.getProperty("oereb.extract.static.map.width.mm", "174"));
		mapHeightMM = Double.valueOf(env.getProperty("oereb.extract.static.map.height.mm", "99"));
		extractMapRatio = mapWidthMM / mapHeightMM;
		
		mapBlowFactor = Double.valueOf(env.getProperty("oereb.extract.static.map.blow-factor", "1.05"));
    }
		
	public WMSImage getImage(String wmsUrl, Envelope parcelExtent) throws WebMapServiceException {
		// Do some math first: We need to calculate the WIDTH and HEIGHT and BBOX 
		// for the GetMap request.
		calculateGetMapParameters(parcelExtent);
		
		// Now create the GetMap request by copying and replacing (some) query parameters.
		String getMapRequest = createGetMapRequest(wmsUrl);
		
		log.debug(getMapRequest);
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
			
			WMSImage wmsImage =  new WMSImage();
			wmsImage.setImage(imageInByte);
			
			String parts[] = wmsBbox.split(",");			
			wmsImage.setEnvelope(Double.valueOf(parts[0]), Double.valueOf(parts[2]), Double.valueOf(parts[1]), Double.valueOf(parts[3]));
			
			wmsImage.setScale(wmsImage.getEnvelope().getWidth(), mapWidthMM/1000);
			
			wmsImage.setDpi(dpi);			
			
			return wmsImage;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		} finally {
			IOUtils.closeQuietly(httpclient);
		}
	}
	
	private void calculateGetMapParameters(Envelope parcelExtent) {
		wmsWidthPx = mapWidthMM / INCH_MM * dpi;
		wmsHeightPx = wmsWidthPx / extractMapRatio;

		double parcelExtentRatio = parcelExtent.getWidth() / parcelExtent.getHeight();
		double minX;
		double minY;
		double maxX;
		double maxY;
		double midpointX = parcelExtent.getMinX() + parcelExtent.getWidth()/2;
		double midpointY = parcelExtent.getMinY() + parcelExtent.getHeight()/2;

		log.debug("parcelExtentRatio: " + String.valueOf(parcelExtentRatio));
		
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
		Envelope bboxEnvelope = new Envelope(minX, maxX, minY, maxY);
		double expandDistance = (bboxEnvelope.getMaxX() - bboxEnvelope.getMinX()) * mapBlowFactor - (bboxEnvelope.getMaxX() - bboxEnvelope.getMinX());
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
				queryBuilder.append(param.getName()).append("=").append(Double.valueOf(wmsWidthPx).intValue()); //TODO: QGIS server 1.8 cannot deal w/ doubles?
			} else if (param.getName().equalsIgnoreCase("HEIGHT")) {
				queryBuilder.append(param.getName()).append("=").append(Double.valueOf(wmsHeightPx).intValue());
			} else {
				if (param.getName().equalsIgnoreCase("FORMAT")) {
					String[] parts = param.getValue().split("/");
					outputFormat = parts[1].toLowerCase();
				}
				queryBuilder.append(param.getName()).append("=").append(param.getValue());
			}		
			idx++;
		}
	
		// TODO:
		// (Our) QGIS server sucks... sorry. Not even URLEncoder.encode() works.
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



