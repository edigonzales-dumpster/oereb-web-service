package ch.so.agi.oereb.web.utils;

import com.vividsolutions.jts.geom.Envelope;

public interface WMSService {

	WMSImage getImage(String wmsUrl, Envelope parcelExtent) throws WMSServiceException;
}
