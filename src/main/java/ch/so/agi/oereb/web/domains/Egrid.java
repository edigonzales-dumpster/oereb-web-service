package ch.so.agi.oereb.web.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Egrid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String egrid;

	private String identdn;

	private String number;
	
	public Egrid() {}

	public String getEgrid() {
		return egrid;
	}

	public void setEgrid(String egrid) {
		this.egrid = egrid;
	}

	public String getIdentdn() {
		return identdn;
	}

	public void setIdentdn(String identdn) {
		this.identdn = identdn;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
