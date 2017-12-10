package ch.so.agi.oereb.web.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "egrid",
    "number",
    "identnd"
})
@XmlRootElement(name = "GetEGRIDResponseType")
public class GetEGRIDResponseType { 
	private String egrid;
	
	private String number;
	
	private String identnd;
	
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
	
	public String getIdentnd() {
		return identnd;
	}
	
	public void setIdentnd(String identnd) {
		this.identnd = identnd;
	}
}
