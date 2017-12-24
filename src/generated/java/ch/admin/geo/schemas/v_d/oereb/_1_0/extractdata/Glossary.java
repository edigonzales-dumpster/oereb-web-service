
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Glossary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Glossary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Title" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualText"/&gt;
 *         &lt;element name="Content" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MultilingualMText"/&gt;
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
@XmlType(name = "Glossary", propOrder = {
    "title",
    "content",
    "extensions"
})
public class Glossary {

    @XmlElement(name = "Title", required = true)
    protected MultilingualText title;
    @XmlElement(name = "Content", required = true)
    protected MultilingualMText content;
    protected Extensions extensions;

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
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualMText }
     *     
     */
    public MultilingualMText getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualMText }
     *     
     */
    public void setContent(MultilingualMText value) {
        this.content = value;
    }

    public boolean isSetContent() {
        return (this.content!= null);
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
