package ch.so.agi.oereb.web.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Immutable;

import com.vividsolutions.jts.geom.Polygon;


// TODO: rename to EgridResponse?

@Entity
@Immutable
@Table(name="v_oereb_real_estate", schema="av_avdpool_ng")
public class EgridParcel {
	@Id
	@GeneratedValue
	private Long t_id;

    //@XmlElement
	private String egrid;
	
    //@XmlElement
	private String number;
	
    //@XmlElement
	private String identdn;
	
	// TODO: this is a test
	//@Transient
	//private String type;
	
	//private String canton;
	
	//private int fosnr;
	
	private Polygon geometrie;

	public Long getT_id() {
		return t_id;
	}
	
	public void setT_id(Long t_id) {
		this.t_id = t_id;
	}

	public String getEgrid() {
		return egrid;
	}
	
	public void setEgrid(String egrid) {
		this.egrid = egrid;
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
	
	public void setIdentnd(String identdn) {
		this.identdn = identdn;
	}

	/*
	public String getType() {
		return type;
	}

	public String getCanton() {
		return canton;
	}

	public int getFosnr() {
		return fosnr;
	}
	*/
	
	public void setGeometrie(Polygon gometrie) {
		this.geometrie = geometrie;
	}
	
	public Polygon getGeometrie() {
		return geometrie;
	}
	
}
