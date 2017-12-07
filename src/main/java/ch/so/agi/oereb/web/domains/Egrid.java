package ch.so.agi.oereb.web.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.vividsolutions.jts.geom.Polygon;

@Entity
@Table(name="v_oereb_real_estate", schema="av_avdpool_ng")
public class Egrid {
	@Id
	@GeneratedValue
	private Long t_id;

	private String egrid;
	
	private String number;
	
	private String identnd;
	
	// TODO: this is a test
	@Transient
	private String type;
	
	private String canton;
	
	private int fosnr;
	
	private Polygon geometrie;

	public Long getT_id() {
		return t_id;
	}

	public String getEgrid() {
		return egrid;
	}

	public String getNumber() {
		return number;
	}

	public String getIdentnd() {
		return identnd;
	}

	public String getType() {
		return type;
	}

	public String getCanton() {
		return canton;
	}

	public int getFosnr() {
		return fosnr;
	}

	public Polygon getGeometrie() {
		return geometrie;
	}
}
