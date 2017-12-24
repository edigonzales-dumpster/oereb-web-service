
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


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}DocumentBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Title" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualText"/&gt;
 *         &lt;element name="OfficialTitle" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualText" minOccurs="0"/&gt;
 *         &lt;element name="Abbreviation" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualText" minOccurs="0"/&gt;
 *         &lt;element name="OfficialNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Canton" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}CantonCode" minOccurs="0"/&gt;
 *         &lt;element name="Municipality" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MunicipalityCode" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOffice" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Office"/&gt;
 *         &lt;element name="ArticleNumber" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}ArticleNumber" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Article" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Article" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Reference" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Document" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "title",
    "officialTitle",
    "abbreviation",
    "officialNumber",
    "canton",
    "municipality",
    "responsibleOffice",
    "articleNumber",
    "article",
    "reference"
})
public class Document
    extends DocumentBase
{

    @XmlElement(name = "Title", required = true)
    protected MultilingualText title;
    @XmlElement(name = "OfficialTitle")
    protected MultilingualText officialTitle;
    @XmlElement(name = "Abbreviation")
    protected MultilingualText abbreviation;
    @XmlElement(name = "OfficialNumber")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String officialNumber;
    @XmlElement(name = "Canton")
    @XmlSchemaType(name = "string")
    protected CantonCode canton;
    @XmlElement(name = "Municipality")
    @XmlSchemaType(name = "integer")
    protected Integer municipality;
    @XmlElement(name = "ResponsibleOffice", required = true)
    protected Office responsibleOffice;
    @XmlElement(name = "ArticleNumber")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected List<String> articleNumber;
    @XmlElement(name = "Article")
    protected List<Article> article;
    @XmlElement(name = "Reference")
    protected List<Document> reference;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualText }
     *     
     */
    public MultilingualText getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualText }
     *     
     */
    public void setTitle(MultilingualText value) {
        this.title = value;
    }

    public boolean isSetTitle() {
        return (this.title!= null);
    }

    /**
     * Gets the value of the officialTitle property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualText }
     *     
     */
    public MultilingualText getOfficialTitle() {
        return officialTitle;
    }

    /**
     * Sets the value of the officialTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualText }
     *     
     */
    public void setOfficialTitle(MultilingualText value) {
        this.officialTitle = value;
    }

    public boolean isSetOfficialTitle() {
        return (this.officialTitle!= null);
    }

    /**
     * Gets the value of the abbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualText }
     *     
     */
    public MultilingualText getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the value of the abbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualText }
     *     
     */
    public void setAbbreviation(MultilingualText value) {
        this.abbreviation = value;
    }

    public boolean isSetAbbreviation() {
        return (this.abbreviation!= null);
    }

    /**
     * Gets the value of the officialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialNumber() {
        return officialNumber;
    }

    /**
     * Sets the value of the officialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialNumber(String value) {
        this.officialNumber = value;
    }

    public boolean isSetOfficialNumber() {
        return (this.officialNumber!= null);
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
     *     {@link Integer }
     *     
     */
    public Integer getMunicipality() {
        return municipality;
    }

    /**
     * Sets the value of the municipality property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMunicipality(Integer value) {
        this.municipality = value;
    }

    public boolean isSetMunicipality() {
        return (this.municipality!= null);
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
     * Gets the value of the articleNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articleNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArticleNumber() {
        if (articleNumber == null) {
            articleNumber = new ArrayList<String>();
        }
        return this.articleNumber;
    }

    public boolean isSetArticleNumber() {
        return ((this.articleNumber!= null)&&(!this.articleNumber.isEmpty()));
    }

    public void unsetArticleNumber() {
        this.articleNumber = null;
    }

    /**
     * Gets the value of the article property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the article property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Article }
     * 
     * 
     */
    public List<Article> getArticle() {
        if (article == null) {
            article = new ArrayList<Article>();
        }
        return this.article;
    }

    public boolean isSetArticle() {
        return ((this.article!= null)&&(!this.article.isEmpty()));
    }

    public void unsetArticle() {
        this.article = null;
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

}
