package ch.so.agi.oereb.web.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.vividsolutions.jts.geom.Polygon;

@Entity
@Immutable
@Table(name="egrid_parcel", schema="agi_oereb_app")
public class EgridParcel extends Egrid {		
	private Polygon geometrie;
	
	public void setGeometrie(Polygon gometrie) {
		this.geometrie = geometrie;
	}
	
	public Polygon getGeometrie() {
		return geometrie;
	}	
}
