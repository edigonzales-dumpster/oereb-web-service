package ch.so.agi.oereb.web.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.vividsolutions.jts.geom.Polygon;

// TODO: cast fosnr number to integer in query 
// but cannot be done with "::"

@Entity
public class RealEstateDPREntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int t_id;
	
	private String number;
	
	private String identdn;
	
	private String egrid;
	
	private String type;
	
	private String canton;
	
	private String municipality;
	
	private String fosnr;

	@Column(name = "metadata_of_geographical_basedata")
	private String metadataOfGeographicalBasedata;
	
	@Column(name = "land_registry_Area")
	private int landRegistryArea;
	
	private Polygon geometry;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getIdentdn() {
		return identdn;
	}
	
	public void setIdentdn(String identdn) {
		this.identdn = identdn;
	}

	public String getEgrid() {
		return egrid;
	}

	public void setEgrid(String egrid) {
		this.egrid = egrid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getFosnr() {
		return fosnr;
	}

	public void setFosnr(String fosnr) {
		this.fosnr = fosnr;
	}

	public String getMetadataOfGeographicalBasedata() {
		return metadataOfGeographicalBasedata;
	}

	public void setMetadataOfGeographicalBasedata(String metadataOfGeographicalBasedata) {
		this.metadataOfGeographicalBasedata = metadataOfGeographicalBasedata;
	}

	public int getLandRegistryArea() {
		return landRegistryArea;
	}

	public void setLandRegistryArea(int landRegistryArea) {
		this.landRegistryArea = landRegistryArea;
	}
	
	public Polygon getGeometry() {
		return geometry;
	}
	
	public void setGeometry(Polygon geometry) {
		this.geometry = geometry;
	}
}
