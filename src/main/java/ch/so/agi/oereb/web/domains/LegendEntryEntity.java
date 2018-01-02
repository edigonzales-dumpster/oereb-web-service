package ch.so.agi.oereb.web.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// TODO: how to handle "SymbolRef" if it's not possible to have optional properties?

@Entity
public class LegendEntryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String t_id;

	private byte[] symbol;
	
	@Column(name = "legend_text")
	private String legendText;
	
	@Column(name = "type_code")
	private String typeCode;
	
	@Column(name = "type_code_list")
	private String typeCodeList;
	
	private String theme;
	
	@Column(name = "subtheme")
	private String subTheme;

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public byte[] getSymbol() {
		return symbol;
	}

	public void setSymbol(byte[] symbol) {
		this.symbol = symbol;
	}

	public String getLegendText() {
		return legendText;
	}

	public void setLegendText(String legendText) {
		this.legendText = legendText;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeCodeList() {
		return typeCodeList;
	}

	public void setTypeCodeList(String typeCodeList) {
		this.typeCodeList = typeCodeList;
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
}
