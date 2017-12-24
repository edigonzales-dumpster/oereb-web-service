
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * <p>Java class for Extract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Extract"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreationDate"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
 *               &lt;minInclusive value="2009-01-01T00:00:00.000"/&gt;
 *               &lt;maxInclusive value="2999-12-31T23:59:59.000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ConcernedTheme" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="NotConcernedTheme" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ThemeWithoutData" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="isReduced" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="LogoPLRCadastre" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *           &lt;element name="LogoPLRCadastreRef" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="FederalLogo" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *           &lt;element name="FederalLogoRef" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CantonalLogo" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *           &lt;element name="CantonalLogoRef" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="MunicipalityLogo" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *           &lt;element name="MunicipalityLogoRef" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="ExtractIdentifier"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="QRCode" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *           &lt;element name="QRCodeRef" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="GeneralInformation" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualMText" minOccurs="0"/&gt;
 *         &lt;element name="BaseData" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualMText"/&gt;
 *         &lt;element name="Glossary" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Glossary" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RealEstate" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}RealEstate_DPR"/&gt;
 *         &lt;element name="ExclusionOfLiability" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}ExclusionOfLiability" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PLRCadastreAuthority" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Office"/&gt;
 *         &lt;element name="Certification" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualMText" minOccurs="0"/&gt;
 *         &lt;element name="CertificationAtWeb" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualUri" minOccurs="0"/&gt;
 *         &lt;element ref="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}extensions" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extract", propOrder = {
    "creationDate",
    "concernedTheme",
    "notConcernedTheme",
    "themeWithoutData",
    "isReduced",
    "logoPLRCadastre",
    "logoPLRCadastreRef",
    "federalLogo",
    "federalLogoRef",
    "cantonalLogo",
    "cantonalLogoRef",
    "municipalityLogo",
    "municipalityLogoRef",
    "extractIdentifier",
    "qrCode",
    "qrCodeRef",
    "generalInformation",
    "baseData",
    "glossary",
    "realEstate",
    "exclusionOfLiability",
    "plrCadastreAuthority",
    "certification",
    "certificationAtWeb",
    "extensions"
})
public class Extract {

    @XmlElement(name = "CreationDate", required = true)
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "ConcernedTheme")
    protected List<Theme> concernedTheme;
    @XmlElement(name = "NotConcernedTheme")
    protected List<Theme> notConcernedTheme;
    @XmlElement(name = "ThemeWithoutData")
    protected List<Theme> themeWithoutData;
    protected boolean isReduced;
    @XmlElement(name = "LogoPLRCadastre")
    protected byte[] logoPLRCadastre;
    @XmlElement(name = "LogoPLRCadastreRef")
    @XmlSchemaType(name = "anyURI")
    protected String logoPLRCadastreRef;
    @XmlElement(name = "FederalLogo")
    protected byte[] federalLogo;
    @XmlElement(name = "FederalLogoRef")
    @XmlSchemaType(name = "anyURI")
    protected String federalLogoRef;
    @XmlElement(name = "CantonalLogo")
    protected byte[] cantonalLogo;
    @XmlElement(name = "CantonalLogoRef")
    @XmlSchemaType(name = "anyURI")
    protected String cantonalLogoRef;
    @XmlElement(name = "MunicipalityLogo")
    protected byte[] municipalityLogo;
    @XmlElement(name = "MunicipalityLogoRef")
    @XmlSchemaType(name = "anyURI")
    protected String municipalityLogoRef;
    @XmlElement(name = "ExtractIdentifier", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String extractIdentifier;
    @XmlElement(name = "QRCode")
    protected byte[] qrCode;
    @XmlElement(name = "QRCodeRef")
    @XmlSchemaType(name = "anyURI")
    protected String qrCodeRef;
    @XmlElement(name = "GeneralInformation")
    protected MultilingualMText generalInformation;
    @XmlElement(name = "BaseData", required = true)
    protected MultilingualMText baseData;
    @XmlElement(name = "Glossary")
    protected List<Glossary> glossary;
    @XmlElement(name = "RealEstate", required = true)
    protected RealEstateDPR realEstate;
    @XmlElement(name = "ExclusionOfLiability")
    protected List<ExclusionOfLiability> exclusionOfLiability;
    @XmlElement(name = "PLRCadastreAuthority", required = true)
    protected Office plrCadastreAuthority;
    @XmlElement(name = "Certification")
    protected MultilingualMText certification;
    @XmlElement(name = "CertificationAtWeb")
    protected MultilingualUri certificationAtWeb;
    protected Extensions extensions;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    public boolean isSetCreationDate() {
        return (this.creationDate!= null);
    }

    /**
     * Gets the value of the concernedTheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concernedTheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcernedTheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Theme }
     * 
     * 
     */
    public List<Theme> getConcernedTheme() {
        if (concernedTheme == null) {
            concernedTheme = new ArrayList<Theme>();
        }
        return this.concernedTheme;
    }

    public boolean isSetConcernedTheme() {
        return ((this.concernedTheme!= null)&&(!this.concernedTheme.isEmpty()));
    }

    public void unsetConcernedTheme() {
        this.concernedTheme = null;
    }

    /**
     * Gets the value of the notConcernedTheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notConcernedTheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotConcernedTheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Theme }
     * 
     * 
     */
    public List<Theme> getNotConcernedTheme() {
        if (notConcernedTheme == null) {
            notConcernedTheme = new ArrayList<Theme>();
        }
        return this.notConcernedTheme;
    }

    public boolean isSetNotConcernedTheme() {
        return ((this.notConcernedTheme!= null)&&(!this.notConcernedTheme.isEmpty()));
    }

    public void unsetNotConcernedTheme() {
        this.notConcernedTheme = null;
    }

    /**
     * Gets the value of the themeWithoutData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the themeWithoutData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThemeWithoutData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Theme }
     * 
     * 
     */
    public List<Theme> getThemeWithoutData() {
        if (themeWithoutData == null) {
            themeWithoutData = new ArrayList<Theme>();
        }
        return this.themeWithoutData;
    }

    public boolean isSetThemeWithoutData() {
        return ((this.themeWithoutData!= null)&&(!this.themeWithoutData.isEmpty()));
    }

    public void unsetThemeWithoutData() {
        this.themeWithoutData = null;
    }

    /**
     * Gets the value of the isReduced property.
     * 
     */
    public boolean isIsReduced() {
        return isReduced;
    }

    /**
     * Sets the value of the isReduced property.
     * 
     */
    public void setIsReduced(boolean value) {
        this.isReduced = value;
    }

    public boolean isSetIsReduced() {
        return true;
    }

    /**
     * Gets the value of the logoPLRCadastre property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getLogoPLRCadastre() {
        return logoPLRCadastre;
    }

    /**
     * Sets the value of the logoPLRCadastre property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setLogoPLRCadastre(byte[] value) {
        this.logoPLRCadastre = value;
    }

    public boolean isSetLogoPLRCadastre() {
        return (this.logoPLRCadastre!= null);
    }

    /**
     * Gets the value of the logoPLRCadastreRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogoPLRCadastreRef() {
        return logoPLRCadastreRef;
    }

    /**
     * Sets the value of the logoPLRCadastreRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogoPLRCadastreRef(String value) {
        this.logoPLRCadastreRef = value;
    }

    public boolean isSetLogoPLRCadastreRef() {
        return (this.logoPLRCadastreRef!= null);
    }

    /**
     * Gets the value of the federalLogo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFederalLogo() {
        return federalLogo;
    }

    /**
     * Sets the value of the federalLogo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFederalLogo(byte[] value) {
        this.federalLogo = value;
    }

    public boolean isSetFederalLogo() {
        return (this.federalLogo!= null);
    }

    /**
     * Gets the value of the federalLogoRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFederalLogoRef() {
        return federalLogoRef;
    }

    /**
     * Sets the value of the federalLogoRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFederalLogoRef(String value) {
        this.federalLogoRef = value;
    }

    public boolean isSetFederalLogoRef() {
        return (this.federalLogoRef!= null);
    }

    /**
     * Gets the value of the cantonalLogo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCantonalLogo() {
        return cantonalLogo;
    }

    /**
     * Sets the value of the cantonalLogo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCantonalLogo(byte[] value) {
        this.cantonalLogo = value;
    }

    public boolean isSetCantonalLogo() {
        return (this.cantonalLogo!= null);
    }

    /**
     * Gets the value of the cantonalLogoRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantonalLogoRef() {
        return cantonalLogoRef;
    }

    /**
     * Sets the value of the cantonalLogoRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantonalLogoRef(String value) {
        this.cantonalLogoRef = value;
    }

    public boolean isSetCantonalLogoRef() {
        return (this.cantonalLogoRef!= null);
    }

    /**
     * Gets the value of the municipalityLogo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getMunicipalityLogo() {
        return municipalityLogo;
    }

    /**
     * Sets the value of the municipalityLogo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setMunicipalityLogo(byte[] value) {
        this.municipalityLogo = value;
    }

    public boolean isSetMunicipalityLogo() {
        return (this.municipalityLogo!= null);
    }

    /**
     * Gets the value of the municipalityLogoRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipalityLogoRef() {
        return municipalityLogoRef;
    }

    /**
     * Sets the value of the municipalityLogoRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipalityLogoRef(String value) {
        this.municipalityLogoRef = value;
    }

    public boolean isSetMunicipalityLogoRef() {
        return (this.municipalityLogoRef!= null);
    }

    /**
     * Gets the value of the extractIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtractIdentifier() {
        return extractIdentifier;
    }

    /**
     * Sets the value of the extractIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtractIdentifier(String value) {
        this.extractIdentifier = value;
    }

    public boolean isSetExtractIdentifier() {
        return (this.extractIdentifier!= null);
    }

    /**
     * Gets the value of the qrCode property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getQRCode() {
        return qrCode;
    }

    /**
     * Sets the value of the qrCode property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setQRCode(byte[] value) {
        this.qrCode = value;
    }

    public boolean isSetQRCode() {
        return (this.qrCode!= null);
    }

    /**
     * Gets the value of the qrCodeRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQRCodeRef() {
        return qrCodeRef;
    }

    /**
     * Sets the value of the qrCodeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQRCodeRef(String value) {
        this.qrCodeRef = value;
    }

    public boolean isSetQRCodeRef() {
        return (this.qrCodeRef!= null);
    }

    /**
     * Gets the value of the generalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualMText }
     *     
     */
    public MultilingualMText getGeneralInformation() {
        return generalInformation;
    }

    /**
     * Sets the value of the generalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualMText }
     *     
     */
    public void setGeneralInformation(MultilingualMText value) {
        this.generalInformation = value;
    }

    public boolean isSetGeneralInformation() {
        return (this.generalInformation!= null);
    }

    /**
     * Gets the value of the baseData property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualMText }
     *     
     */
    public MultilingualMText getBaseData() {
        return baseData;
    }

    /**
     * Sets the value of the baseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualMText }
     *     
     */
    public void setBaseData(MultilingualMText value) {
        this.baseData = value;
    }

    public boolean isSetBaseData() {
        return (this.baseData!= null);
    }

    /**
     * Gets the value of the glossary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the glossary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlossary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Glossary }
     * 
     * 
     */
    public List<Glossary> getGlossary() {
        if (glossary == null) {
            glossary = new ArrayList<Glossary>();
        }
        return this.glossary;
    }

    public boolean isSetGlossary() {
        return ((this.glossary!= null)&&(!this.glossary.isEmpty()));
    }

    public void unsetGlossary() {
        this.glossary = null;
    }

    /**
     * Gets the value of the realEstate property.
     * 
     * @return
     *     possible object is
     *     {@link RealEstateDPR }
     *     
     */
    public RealEstateDPR getRealEstate() {
        return realEstate;
    }

    /**
     * Sets the value of the realEstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealEstateDPR }
     *     
     */
    public void setRealEstate(RealEstateDPR value) {
        this.realEstate = value;
    }

    public boolean isSetRealEstate() {
        return (this.realEstate!= null);
    }

    /**
     * Gets the value of the exclusionOfLiability property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exclusionOfLiability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExclusionOfLiability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExclusionOfLiability }
     * 
     * 
     */
    public List<ExclusionOfLiability> getExclusionOfLiability() {
        if (exclusionOfLiability == null) {
            exclusionOfLiability = new ArrayList<ExclusionOfLiability>();
        }
        return this.exclusionOfLiability;
    }

    public boolean isSetExclusionOfLiability() {
        return ((this.exclusionOfLiability!= null)&&(!this.exclusionOfLiability.isEmpty()));
    }

    public void unsetExclusionOfLiability() {
        this.exclusionOfLiability = null;
    }

    /**
     * Gets the value of the plrCadastreAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link Office }
     *     
     */
    public Office getPLRCadastreAuthority() {
        return plrCadastreAuthority;
    }

    /**
     * Sets the value of the plrCadastreAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Office }
     *     
     */
    public void setPLRCadastreAuthority(Office value) {
        this.plrCadastreAuthority = value;
    }

    public boolean isSetPLRCadastreAuthority() {
        return (this.plrCadastreAuthority!= null);
    }

    /**
     * Gets the value of the certification property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualMText }
     *     
     */
    public MultilingualMText getCertification() {
        return certification;
    }

    /**
     * Sets the value of the certification property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualMText }
     *     
     */
    public void setCertification(MultilingualMText value) {
        this.certification = value;
    }

    public boolean isSetCertification() {
        return (this.certification!= null);
    }

    /**
     * Gets the value of the certificationAtWeb property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualUri }
     *     
     */
    public MultilingualUri getCertificationAtWeb() {
        return certificationAtWeb;
    }

    /**
     * Sets the value of the certificationAtWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualUri }
     *     
     */
    public void setCertificationAtWeb(MultilingualUri value) {
        this.certificationAtWeb = value;
    }

    public boolean isSetCertificationAtWeb() {
        return (this.certificationAtWeb!= null);
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

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
