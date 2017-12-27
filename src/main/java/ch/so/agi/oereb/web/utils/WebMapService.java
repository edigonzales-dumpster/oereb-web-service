package ch.so.agi.oereb.web.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.geotools.data.ows.Layer;
import org.geotools.data.ows.WMSCapabilities;
import org.geotools.data.wms.WebMapServer;
import org.geotools.data.wms.request.GetMapRequest;
import org.geotools.data.wms.response.GetMapResponse;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class WebMapService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final double INCH_MM = 25.4;

	private URL getCapabilitiesUrl;
	private WebMapServer wms = null;
	
	private String layers = null; // TODO: Should pre-process the layer string since it only works with a single layer.
	private String format = "image/png";
	
	private int dpi = 96; // TODO: must be higher!
	private double paperWidthMM = 174; // see "Weisung"
	private double paperHeightMM = 99; // see "Weisung"
	private double extractMapRatio = paperWidthMM / paperHeightMM; 
	private double bboxExpandScale = 1.1;
	
	private String[] getMapIgnoreParameters = {"REQUEST", "STYLES", "SRS", "BBOX", "WIDTH", "HEIGHT", "FORMAT", "LAYERS"};

	/**
	 * Creates a GeoTools WebMapService object. If a getMap url is used, 
	 * it will try to convert it to a getCapabilities url.
	 * 
	 * @param WMS URL (GetMap or GetCapabilities)
	 */
	
	public WebMapService(String wmsUrl) throws WebMapServiceException {		
		try {	
			String getCapabilitiesUrl;
			log.info("wmsUrl: " + wmsUrl);
			if (wmsUrl.toLowerCase().contains("REQUEST=GetCapabilities".toLowerCase())) {
				getCapabilitiesUrl = wmsUrl;
			} else {
				getCapabilitiesUrl = getMap2getCapabilities(wmsUrl);
			}
			log.info("getCapabilitiesUrl: " + getCapabilitiesUrl);
			this.getCapabilitiesUrl = new URL(getCapabilitiesUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		}
		try {
			wms = new WebMapServer(this.getCapabilitiesUrl);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		}		
	}
	
	public void getMap(String layers, Envelope extent) throws URISyntaxException {
		this.layers = layers;
	}

	
	public byte[] getMap(Envelope extent) throws URISyntaxException, WebMapServiceException {		
		GetMapRequest request = wms.createGetMapRequest();
		request.addLayer(layers, ""); //TODO: Works with one layer and with one only!
		request.setFormat(this.format);
		request.setTransparent(true);
		request.setSRS("EPSG:2056"); //TODO: do not hardcode?!

		double width = this.paperWidthMM / this.INCH_MM * dpi;
		request.setDimensions(String.valueOf(width), String.valueOf(width / extractMapRatio));

		double parcelExtentRatio = extent.getWidth() / extent.getHeight();
		double minX;
		double minY;
		double maxX;
		double maxY;
		double midpointX = extent.getMinX() + extent.getWidth()/2;
		double midpointY = extent.getMinY() + extent.getHeight()/2;
		
		log.info("parcelExtentRatio: " + String.valueOf(parcelExtentRatio));
		
		// TODO: TEST THIS CAREFULLY!!!!!!!!!!
		if (extractMapRatio < parcelExtentRatio) {
			minX = midpointX - extent.getWidth()/2;
			minY = midpointY - (extent.getWidth()/2 / extractMapRatio);
			
			maxX = midpointX + extent.getWidth()/2;
			maxY = midpointY + (extent.getWidth()/2 / extractMapRatio);
		} else {
			minX = midpointX - extent.getHeight()/2 * extractMapRatio;
			minY = midpointY - (extent.getHeight()/2 );
			
			maxX = midpointX + extent.getHeight()/2 * extractMapRatio;
			maxY = midpointY + (extent.getHeight()/2 );
		}
		
		// Must be the same as extractMapRatio.
		double l = maxX - minX;
		double h = maxY - minY;
		log.debug(String.valueOf("bboxRatio: " + l/h) + " -- extractMapRatio: " + extractMapRatio);
		
		// Expand bbox to get a better visual result.
		Envelope bboxEnvelope = new Envelope(new Coordinate(minX, minY), new Coordinate(maxX, maxY));
		double expandDistance = (bboxEnvelope.getMaxX() - bboxEnvelope.getMinX()) * bboxExpandScale - (bboxEnvelope.getMaxX() - bboxEnvelope.getMinX());
		bboxEnvelope.expandBy(expandDistance, expandDistance / extractMapRatio);
				
		String bbox = bboxEnvelope.getMinX() + "," + bboxEnvelope.getMinY() + "," + bboxEnvelope.getMaxX()  + "," + bboxEnvelope.getMaxY();
		request.setBBox(bbox);
		
//		log.info(request.getFinalURL().toString());
//		System.out.println(request.getFinalURL().toString());
		
		try {
			GetMapResponse response = (GetMapResponse) wms.issueRequest(request);
			BufferedImage image = ImageIO.read(response.getInputStream());

			// Save image as byte array (needed by jaxb)
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
			
			// Save image to base64
//		    final ByteArrayOutputStream os = new ByteArrayOutputStream();
//	        ImageIO.write(image, "png", Base64.getEncoder().wrap(os));
//	        String base64img = os.toString(StandardCharsets.UTF_8.name());
//	        return base64img;
			
			// Save image to local file system.
//			Path tmpDirectory = Files.createTempDirectory(Paths.get(System.getProperty("java.io.tmpdir")), "oereb");
//			Path outputfilePath = Paths.get(tmpDirectory.toString(), "image.png");
//			ImageIO.write(image, "png", outputfilePath.toFile());
//			log.info(outputfilePath.toString());
			
		} catch (org.geotools.ows.ServiceException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		}
	}
	
	/*
	 * Alles, was explizit zu einem GetMap-Request gehört, wird ignoriert.
	 * REQUEST-Type wird zu GetCapabilities.
	 * Alles andere wird weiterverwendet.
	 */
	
	private String getMap2getCapabilities(String getMapUrl) throws WebMapServiceException {
		Charset charset = Charset.forName("UTF-8");
		List<org.apache.http.NameValuePair> params;
		URI getMapUri;
		try {
			getMapUri = new URI(getMapUrl);
			params = URLEncodedUtils.parse(getMapUri, charset);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new WebMapServiceException(e.getMessage());
		}
		
		String schema = getMapUri.getScheme();
		String host = getMapUri.getHost();
		
		String port = "";
		if (getMapUri.getPort() > 0) {
			port = String.valueOf(getMapUri.getPort());
		}
				
		StringBuilder getCapabilitiesUrlBuilder = new StringBuilder();
		getCapabilitiesUrlBuilder.append(schema);
		getCapabilitiesUrlBuilder.append("://");
		getCapabilitiesUrlBuilder.append(host);
		
		if (!port.equalsIgnoreCase("")) {
			getCapabilitiesUrlBuilder.append(":").append(port);
		}

		StringBuilder queryBuilder = new StringBuilder();
		int idx = 0;
		for (org.apache.http.NameValuePair param : params) {
			if (Arrays.asList(getMapIgnoreParameters).contains(param.getName().toUpperCase())) {
				if (param.getName().equalsIgnoreCase("LAYERS")) {
					this.layers = param.getValue();
				} 
				if (param.getName().equalsIgnoreCase("FORMAT")) {
					this.format = param.getValue();
				}
			} else {
				if (idx > 0) {
					queryBuilder.append("&");
				}
				queryBuilder.append(param.getName()).append("=").append(param.getValue());
			}
			idx++;
		}

		queryBuilder.append("&SERVICE=GetCapabilities");
		
		if (queryBuilder.toString() != null) {
			getCapabilitiesUrlBuilder.append("?").append(queryBuilder);
		}
	
		return getCapabilitiesUrlBuilder.toString();
	}	
}
