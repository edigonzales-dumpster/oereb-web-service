package ch.so.agi.oereb.web.utils;

import com.vividsolutions.jts.geom.Envelope;

public class WMSImage {
	private byte[] image;
	
	private Envelope envelope;
	
	private double scale;
	
	private int dpi;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Envelope getEnvelope() {
		return envelope;
	}

	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}
	
	public void setEnvelope(double minX, double maxX, double minY, double maxY) {
		this.envelope = new Envelope(minX, maxX, minY, maxY);
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}
	
	public void setScale(double realWorldLengthM, double mapLengthM) {
		this.scale = realWorldLengthM / mapLengthM;
	}

	public int getDpi() {
		return dpi;
	}

	public void setDpi(int dpi) {
		this.dpi = dpi;
	}
}
