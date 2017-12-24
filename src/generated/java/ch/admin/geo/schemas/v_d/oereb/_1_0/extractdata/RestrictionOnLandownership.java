
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for RestrictionOnLandownership complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RestrictionOnLandownership"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Information" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualMText"/&gt;
 *         &lt;element name="Theme" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme"/&gt;
 *         &lt;element name="SubTheme" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TypeCode" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}RestrictiontypeCode" minOccurs="0"/&gt;
 *         &lt;element name="TypeCodelist" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;element name="Lawstatus" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Lawstatus"/&gt;
 *         &lt;element name="AreaShare" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Area" minOccurs="0"/&gt;
 *         &lt;element name="LengthShare" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Length" minOccurs="0"/&gt;
 *         &lt;element name="NrOfPoints" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *               &lt;maxInclusive value="10000000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PartInPercent" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *               &lt;maxInclusive value="100.0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Symbol" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *           &lt;element name="SymbolRef" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Geometry" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Geometry" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Map" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Map"/&gt;
 *         &lt;element name="LegalProvisions" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}DocumentBase" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOffice" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Office"/&gt;
 *         &lt;element ref="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}extensions" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestrictionOnLandownership", propOrder = {
    "information",
    "theme",
    "subTheme",
    "typeCode",
    "typeCodelist",
    "lawstatus",
    "areaShare",
    "lengthShare",
    "nrOfPoints",
    "partInPercent",
    "symbol",
    "symbolRef",
    "geometry",
    "map",
    "legalProvisions",
    "responsibleOffice",
    "extensions"
})
public class RestrictionOnLandownership {

    @XmlElement(name = "Information", required = true)
    protected MultilingualMText information;
    @XmlElement(name = "Theme", required = true)
    protected Theme theme;
    @XmlElement(name = "SubTheme")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String subTheme;
    @XmlElement(name = "TypeCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String typeCode;
    @XmlElement(name = "TypeCodelist")
    @XmlSchemaType(name = "anyURI")
    protected String typeCodelist;
    @XmlElement(name = "Lawstatus", required = true)
    protected Lawstatus lawstatus;
    @XmlElement(name = "AreaShare")
    @XmlSchemaType(name = "integer")
    protected Integer areaShare;
    @XmlElement(name = "LengthShare")
    @XmlSchemaType(name = "integer")
    protected Integer lengthShare;
    @XmlElement(name = "NrOfPoints")
    protected Integer nrOfPoints;
    @XmlElement(name = "PartInPercent")
    protected BigDecimal partInPercent;
    @XmlElement(name = "Symbol")
    protected byte[] symbol;
    @XmlElement(name = "SymbolRef")
    @XmlSchemaType(name = "anyURI")
    protected String symbolRef;
    @XmlElement(name = "Geometry", required = true)
    protected List<Geometry> geometry;
    @XmlElement(name = "Map", required = true)
    protected Map map;
    @XmlElement(name = "LegalProvisions")
    protected List<DocumentBase> legalProvisions;
    @XmlElement(name = "ResponsibleOffice", required = true)
    protected Office responsibleOffice;
    protected Extensions extensions;

    /**
     * Gets the value of the information property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualMText }
     *     
     */
    public MultilingualMText getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualMText }
     *     
     */
    public void setInformation(MultilingualMText value) {
        this.information = value;
    }

    public boolean isSetInformation() {
        return (this.information!= null);
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

    public boolean isSetTheme() {
        return (this.theme!= null);
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

    public boolean isSetSubTheme() {
        return (this.subTheme!= null);
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

    public boolean isSetTypeCode() {
        return (this.typeCode!= null);
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

    public boolean isSetTypeCodelist() {
        return (this.typeCodelist!= null);
    }

    /**
     * Gets the value of the lawstatus property.
     * 
     * @return
     *     possible object is
     *     {@link Lawstatus }
     *     
     */
    public Lawstatus getLawstatus() {
        return lawstatus;
    }

    /**
     * Sets the value of the lawstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lawstatus }
     *     
     */
    public void setLawstatus(Lawstatus value) {
        this.lawstatus = value;
    }

    public boolean isSetLawstatus() {
        return (this.lawstatus!= null);
    }

    /**
     * Gets the value of the areaShare property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAreaShare() {
        return areaShare;
    }

    /**
     * Sets the value of the areaShare property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAreaShare(Integer value) {
        this.areaShare = value;
    }

    public boolean isSetAreaShare() {
        return (this.areaShare!= null);
    }

    /**
     * Gets the value of the lengthShare property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLengthShare() {
        return lengthShare;
    }

    /**
     * Sets the value of the lengthShare property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLengthShare(Integer value) {
        this.lengthShare = value;
    }

    public boolean isSetLengthShare() {
        return (this.lengthShare!= null);
    }

    /**
     * Gets the value of the nrOfPoints property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNrOfPoints() {
        return nrOfPoints;
    }

    /**
     * Sets the value of the nrOfPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNrOfPoints(Integer value) {
        this.nrOfPoints = value;
    }

    public boolean isSetNrOfPoints() {
        return (this.nrOfPoints!= null);
    }

    /**
     * Gets the value of the partInPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPartInPercent() {
        return partInPercent;
    }

    /**
     * Sets the value of the partInPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPartInPercent(BigDecimal value) {
        this.partInPercent = value;
    }

    public boolean isSetPartInPercent() {
        return (this.partInPercent!= null);
    }

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

    public boolean isSetSymbol() {
        return (this.symbol!= null);
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

    public boolean isSetSymbolRef() {
        return (this.symbolRef!= null);
    }

    /**
     * Gets the value of the geometry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geometry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeometry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Geometry }
     * 
     * 
     */
    public List<Geometry> getGeometry() {
        if (geometry == null) {
            geometry = new ArrayList<Geometry>();
        }
        return this.geometry;
    }

    public boolean isSetGeometry() {
        return ((this.geometry!= null)&&(!this.geometry.isEmpty()));
    }

    public void unsetGeometry() {
        this.geometry = null;
    }

    /**
     * Gets the value of the map property.
     * 
     * @return
     *     possible object is
     *     {@link Map }
     *     
     */
    public Map getMap() {
        return map;
    }

    /**
     * Sets the value of the map property.
     * 
     * @param value
     *     allowed object is
     *     {@link Map }
     *     
     */
    public void setMap(Map value) {
        this.map = value;
    }

    public boolean isSetMap() {
        return (this.map!= null);
    }

    /**
     * Gets the value of the legalProvisions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legalProvisions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegalProvisions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentBase }
     * 
     * 
     */
    public List<DocumentBase> getLegalProvisions() {
        if (legalProvisions == null) {
            legalProvisions = new ArrayList<DocumentBase>();
        }
        return this.legalProvisions;
    }

    public boolean isSetLegalProvisions() {
        return ((this.legalProvisions!= null)&&(!this.legalProvisions.isEmpty()));
    }

    public void unsetLegalProvisions() {
        this.legalProvisions = null;
    }

    /**
     * Gets the value of the responsibleOffice property.
     * 
     * @return
     *     possible object is
     *     {@link Office }
     *     
     */
    public Office getResponsibleOffice() {
        return responsibleOffice;
    }

    /**
     * Sets the value of the responsibleOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Office }
     *     
     */
    public void setResponsibleOffice(Office value) {
        this.responsibleOffice = value;
    }

    public boolean isSetResponsibleOffice() {
        return (this.responsibleOffice!= null);
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

    public boolean isSetExtensions() {
        return (this.extensions!= null);
    }

}
