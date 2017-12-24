
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import net.opengis.gml.v_3_2_1.MultiSurfacePropertyType;


/**
 * <p>Java class for RealEstate_DPR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RealEstate_DPR"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Number" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="12"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IdentDN" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="12"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="EGRID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="14"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Type" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}RealEstateType"/&gt;
 *         &lt;element name="Canton" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}CantonCode"/&gt;
 *         &lt;element name="Municipality"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SubunitOfLandRegister" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FosNr" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MunicipalityCode"/&gt;
 *         &lt;element name="MetadataOfGeographicalBaseData" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;element name="LandRegistryArea" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Area"/&gt;
 *         &lt;element name="Limit" type="{http://www.opengis.net/gml/3.2}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="RestrictionOnLandownership" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}RestrictionOnLandownership" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PlanForLandRegister" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Map"/&gt;
 *         &lt;element name="PlanForLandRegisterMainPage" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Map"/&gt;
 *         &lt;element name="Reference" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Document" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "RealEstate_DPR", propOrder = {
    "number",
    "identDN",
    "egrid",
    "type",
    "canton",
    "municipality",
    "subunitOfLandRegister",
    "fosNr",
    "metadataOfGeographicalBaseData",
    "landRegistryArea",
    "limit",
    "restrictionOnLandownership",
    "planForLandRegister",
    "planForLandRegisterMainPage",
    "reference",
    "extensions"
})
public class RealEstateDPR {

    @XmlElement(name = "Number")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String number;
    @XmlElement(name = "IdentDN")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String identDN;
    @XmlElement(name = "EGRID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String egrid;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected RealEstateType type;
    @XmlElement(name = "Canton", required = true)
    @XmlSchemaType(name = "string")
    protected CantonCode canton;
    @XmlElement(name = "Municipality", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String municipality;
    @XmlElement(name = "SubunitOfLandRegister")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String subunitOfLandRegister;
    @XmlElement(name = "FosNr")
    @XmlSchemaType(name = "integer")
    protected int fosNr;
    @XmlElement(name = "MetadataOfGeographicalBaseData")
    @XmlSchemaType(name = "anyURI")
    protected String metadataOfGeographicalBaseData;
    @XmlElement(name = "LandRegistryArea")
    @XmlSchemaType(name = "integer")
    protected int landRegistryArea;
    @XmlElement(name = "Limit")
    protected MultiSurfacePropertyType limit;
    @XmlElement(name = "RestrictionOnLandownership")
    protected List<RestrictionOnLandownership> restrictionOnLandownership;
    @XmlElement(name = "PlanForLandRegister", required = true)
    protected Map planForLandRegister;
    @XmlElement(name = "PlanForLandRegisterMainPage", required = true)
    protected Map planForLandRegisterMainPage;
    @XmlElement(name = "Reference")
    protected List<Document> reference;
    protected Extensions extensions;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    public boolean isSetNumber() {
        return (this.number!= null);
    }

    /**
     * Gets the value of the identDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentDN() {
        return identDN;
    }

    /**
     * Sets the value of the identDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentDN(String value) {
        this.identDN = value;
    }

    public boolean isSetIdentDN() {
        return (this.identDN!= null);
    }

    /**
     * Gets the value of the egrid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEGRID() {
        return egrid;
    }

    /**
     * Sets the value of the egrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEGRID(String value) {
        this.egrid = value;
    }

    public boolean isSetEGRID() {
        return (this.egrid!= null);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link RealEstateType }
     *     
     */
    public RealEstateType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealEstateType }
     *     
     */
    public void setType(RealEstateType value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the canton property.
     * 
     * @return
     *     possible object is
     *     {@link CantonCode }
     *     
     */
    public CantonCode getCanton() {
        return canton;
    }

    /**
     * Sets the value of the canton property.
     * 
     * @param value
     *     allowed object is
     *     {@link CantonCode }
     *     
     */
    public void setCanton(CantonCode value) {
        this.canton = value;
    }

    public boolean isSetCanton() {
        return (this.canton!= null);
    }

    /**
     * Gets the value of the municipality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Sets the value of the municipality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipality(String value) {
        this.municipality = value;
    }

    public boolean isSetMunicipality() {
        return (this.municipality!= null);
    }

    /**
     * Gets the value of the subunitOfLandRegister property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubunitOfLandRegister() {
        return subunitOfLandRegister;
    }

    /**
     * Sets the value of the subunitOfLandRegister property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubunitOfLandRegister(String value) {
        this.subunitOfLandRegister = value;
    }

    public boolean isSetSubunitOfLandRegister() {
        return (this.subunitOfLandRegister!= null);
    }

    /**
     * Gets the value of the fosNr property.
     * 
     */
    public int getFosNr() {
        return fosNr;
    }

    /**
     * Sets the value of the fosNr property.
     * 
     */
    public void setFosNr(int value) {
        this.fosNr = value;
    }

    public boolean isSetFosNr() {
        return true;
    }

    /**
     * Gets the value of the metadataOfGeographicalBaseData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetadataOfGeographicalBaseData() {
        return metadataOfGeographicalBaseData;
    }

    /**
     * Sets the value of the metadataOfGeographicalBaseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetadataOfGeographicalBaseData(String value) {
        this.metadataOfGeographicalBaseData = value;
    }

    public boolean isSetMetadataOfGeographicalBaseData() {
        return (this.metadataOfGeographicalBaseData!= null);
    }

    /**
     * Gets the value of the landRegistryArea property.
     * 
     */
    public int getLandRegistryArea() {
        return landRegistryArea;
    }

    /**
     * Sets the value of the landRegistryArea property.
     * 
     */
    public void setLandRegistryArea(int value) {
        this.landRegistryArea = value;
    }

    public boolean isSetLandRegistryArea() {
        return true;
    }

    /**
     * Gets the value of the limit property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLimit(MultiSurfacePropertyType value) {
        this.limit = value;
    }

    public boolean isSetLimit() {
        return (this.limit!= null);
    }

    /**
     * Gets the value of the restrictionOnLandownership property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the restrictionOnLandownership property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRestrictionOnLandownership().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RestrictionOnLandownership }
     * 
     * 
     */
    public List<RestrictionOnLandownership> getRestrictionOnLandownership() {
        if (restrictionOnLandownership == null) {
            restrictionOnLandownership = new ArrayList<RestrictionOnLandownership>();
        }
        return this.restrictionOnLandownership;
    }

    public boolean isSetRestrictionOnLandownership() {
        return ((this.restrictionOnLandownership!= null)&&(!this.restrictionOnLandownership.isEmpty()));
    }

    public void unsetRestrictionOnLandownership() {
        this.restrictionOnLandownership = null;
    }

    /**
     * Gets the value of the planForLandRegister property.
     * 
     * @return
     *     possible object is
     *     {@link Map }
     *     
     */
    public Map getPlanForLandRegister() {
        return planForLandRegister;
    }

    /**
     * Sets the value of the planForLandRegister property.
     * 
     * @param value
     *     allowed object is
     *     {@link Map }
     *     
     */
    public void setPlanForLandRegister(Map value) {
        this.planForLandRegister = value;
    }

    public boolean isSetPlanForLandRegister() {
        return (this.planForLandRegister!= null);
    }

    /**
     * Gets the value of the planForLandRegisterMainPage property.
     * 
     * @return
     *     possible object is
     *     {@link Map }
     *     
     */
    public Map getPlanForLandRegisterMainPage() {
        return planForLandRegisterMainPage;
    }

    /**
     * Sets the value of the planForLandRegisterMainPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Map }
     *     
     */
    public void setPlanForLandRegisterMainPage(Map value) {
        this.planForLandRegisterMainPage = value;
    }

    public boolean isSetPlanForLandRegisterMainPage() {
        return (this.planForLandRegisterMainPage!= null);
    }

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Document }
     * 
     * 
     */
    public List<Document> getReference() {
        if (reference == null) {
            reference = new ArrayList<Document>();
        }
        return this.reference;
    }

    public boolean isSetReference() {
        return ((this.reference!= null)&&(!this.reference.isEmpty()));
    }

    public void unsetReference() {
        this.reference = null;
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
