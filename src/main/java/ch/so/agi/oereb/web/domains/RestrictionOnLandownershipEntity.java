package ch.so.agi.oereb.web.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class RestrictionOnLandownershipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// TODO: t_id will not be unique. 
	// E.g. large geometry that will be cut in many pieces after intersection.
	// Is this relevant since we only read and we use one query only?
	@Id
	private int t_id;
	
	private int restriction_t_id;
	
	private String information;
	
	private String theme;
	
	@Column(name = "subtheme")
	private String subTheme;
	
	@Column(name = "law_status")
	private String lawStatus;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSubTheme() {
		return subTheme;
	}

	public void setSubTheme(String subTheme) {
		this.subTheme = subTheme;
	}

	public String getLawStatus() {
		return lawStatus;
	}

	public void setLawStatus(String lawStatus) {
		this.lawStatus = lawStatus;
	}

	public int getRestriction_t_id() {
		return restriction_t_id;
	}

	public void setRestriction_id(int restriction_t_id) {
		this.restriction_t_id = restriction_t_id;
	}	
}
