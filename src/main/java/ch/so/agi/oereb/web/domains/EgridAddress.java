package ch.so.agi.oereb.web.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="egrid_address", schema="agi_oereb_app")
public class EgridAddress extends Egrid {	
	
	// This is needed for the distinct query in the repository.
	// DTO style?
	public EgridAddress(String egrid, String identdn, String number) {
		this.egrid = egrid;
		this.identdn = identdn;
		this.number = number;
	}
	
	private int postalcode;
	
	private String localisation;
	
	@Column(name = "housing_number")
	private String housingNumber;

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getHousingNumber() {
		return housingNumber;
	}

	public void setHousingNumber(String housingNumber) {
		this.housingNumber = housingNumber;
	}
}
