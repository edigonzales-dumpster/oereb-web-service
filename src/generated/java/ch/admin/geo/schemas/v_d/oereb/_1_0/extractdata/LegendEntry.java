//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.16 at 02:30:28 PM CET 
//


package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LegendEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegendEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Symbol" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *           &lt;element name="SymbolRef" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;/choice>
 *         &lt;element name="LegendText" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualText"/>
 *         &lt;element name="TypeCode" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}RestrictiontypeCode"/>
 *         &lt;element name="TypeCodelist" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="Theme" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme"/>
 *         &lt;element name="SubTheme" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegendEntry", propOrder = {
    "symbol",
    "symbolRef",
    "legendText",
    "typeCode",
    "typeCodelist",
    "theme",
    "subTheme",
    "extensions"
})
public class LegendEntry {

    @XmlElement(name = "Symbol")
    protected byte[] symbol;
    @XmlElement(name = "SymbolRef")
    @XmlSchemaType(name = "anyURI")
    protected String symbolRef;
    @XmlElement(name = "LegendText", required = true)
    protected MultilingualText legendText;
    @XmlElement(name = "TypeCode", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String typeCode;
    @XmlElement(name = "TypeCodelist", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String typeCodelist;
    @XmlElement(name = "Theme", required = true)
    protected Theme theme;
    @XmlElement(name = "SubTheme")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String subTheme;
    protected Extensions extensions;

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSymbol(byte[] value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the symbolRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbolRef() {
        return symbolRef;
    }

    /**
     * Sets the value of the symbolRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbolRef(String value) {
        this.symbolRef = value;
    }

    /**
     * Gets the value of the legendText property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualText }
     *     
     */
    public MultilingualText getLegendText() {
        return legendText;
    }

    /**
     * Sets the value of the legendText property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualText }
     *     
     */
    public void setLegendText(MultilingualText value) {
        this.legendText = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCode(String value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the typeCodelist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCodelist() {
        return typeCodelist;
    }

    /**
     * Sets the value of the typeCodelist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCodelist(String value) {
        this.typeCodelist = value;
    }

    /**
     * Gets the value of the theme property.
     * 
     * @return
     *     possible object is
     *     {@link Theme }
     *     
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Sets the value of the theme property.
     * 
     * @param value
     *     allowed object is
     *     {@link Theme }
     *     
     */
    public void setTheme(Theme value) {
        this.theme = value;
    }

    /**
     * Gets the value of the subTheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTheme() {
        return subTheme;
    }

    /**
     * Sets the value of the subTheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTheme(String value) {
        this.subTheme = value;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link Extensions }
     *     
     */
    public Extensions getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extensions }
     *     
     */
    public void setExtensions(Extensions value) {
        this.extensions = value;
    }

}
