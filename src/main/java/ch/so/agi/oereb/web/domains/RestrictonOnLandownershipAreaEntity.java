package ch.so.agi.oereb.web.domains;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.vividsolutions.jts.geom.Polygon;

@Entity
public class RestrictonOnLandownershipAreaEntity extends RestrictionOnLandownershipEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "area_share")
	private int areaShare;
		
	@Column(name = "part_in_percent")
	private double partInPercent;
	
	//TODO: Überlegen, ob mehrere Geometrien als Multipolygon oder als mehrere Objekte. 
	// Kommt auf Anforderung Data-Exract und auf Query an.
	private Polygon geometry;

	public int getAreaShare() {
		return areaShare;
	}

	public void setAreaShare(int areaShare) {
		this.areaShare = areaShare;
	}

	public double getPartInPercent() {
		return partInPercent;
	}

	public void setPartInPercent(double partInPercent) {
		this.partInPercent = partInPercent;
	}

	public Polygon getGeometry() {
		return geometry;
	}

	public void setGeometry(Polygon geometry) {
		this.geometry = geometry;
	} 
}
