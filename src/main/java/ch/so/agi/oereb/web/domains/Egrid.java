package ch.so.agi.oereb.web.domains;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Egrid {
	@Id
	@GeneratedValue
	protected Long t_id;

	protected String egrid;
	
	protected String number;
	
	protected String identdn;

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

	public void setIdentdn(String identdn) {
		this.identdn = identdn;
	}
}
