
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Lawstatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Lawstatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Code" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}LawstatusCode"/&gt;
 *         &lt;element name="Text" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}LocalisedText"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lawstatus", propOrder = {
    "code",
    "text"
})
public class Lawstatus {

    @XmlElement(name = "Code", required = true)
    @XmlSchemaType(name = "string")
    protected LawstatusCode code;
    @XmlElement(name = "Text", required = true)
    protected LocalisedText text;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link LawstatusCode }
     *     
     */
    public LawstatusCode getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link LawstatusCode }
     *     
     */
    public void setCode(LawstatusCode value) {
        this.code = value;
    }

    public boolean isSetCode() {
        return (this.code!= null);
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link LocalisedText }
     *     
     */
    public LocalisedText getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalisedText }
     *     
     */
    public void setText(LocalisedText value) {
        this.text = value;
    }

    public boolean isSetText() {
        return (this.text!= null);
    }

}
