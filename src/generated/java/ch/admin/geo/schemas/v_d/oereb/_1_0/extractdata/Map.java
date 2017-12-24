
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.PointPropertyType;


/**
 * <p>Java class for Map complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Map"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceWMS" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;element name="LegendAtWeb" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}WebReference" minOccurs="0"/&gt;
 *         &lt;element name="OtherLegend" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}LegendEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="min_NS03" type="{http://www.opengis.net/gml/3.2}PointPropertyType"/&gt;
 *             &lt;element name="max_NS03" type="{http://www.opengis.net/gml/3.2}PointPropertyType"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="min_NS95" type="{http://www.opengis.net/gml/3.2}PointPropertyType"/&gt;
 *             &lt;element name="max_NS95" type="{http://www.opengis.net/gml/3.2}PointPropertyType"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="layerIndex"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="-1000"/&gt;
 *               &lt;maxInclusive value="1000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="layerOpacity"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&gt;
 *               &lt;minInclusive value="0.000"/&gt;
 *               &lt;maxInclusive value="1.000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "Map", propOrder = {
    "image",
    "referenceWMS",
    "legendAtWeb",
    "otherLegend",
    "minNS03",
    "maxNS03",
    "minNS95",
    "maxNS95",
    "layerIndex",
    "layerOpacity",
    "extensions"
})
public class Map {

    @XmlElement(name = "Image")
    protected byte[] image;
    @XmlElement(name = "ReferenceWMS")
    @XmlSchemaType(name = "anyURI")
    protected String referenceWMS;
    @XmlElement(name = "LegendAtWeb")
    protected WebReference legendAtWeb;
    @XmlElement(name = "OtherLegend")
    protected List<LegendEntry> otherLegend;
    @XmlElement(name = "min_NS03")
    protected PointPropertyType minNS03;
    @XmlElement(name = "max_NS03")
    protected PointPropertyType maxNS03;
    @XmlElement(name = "min_NS95")
    protected PointPropertyType minNS95;
    @XmlElement(name = "max_NS95")
    protected PointPropertyType maxNS95;
    protected int layerIndex;
    protected double layerOpacity;
    protected Extensions extensions;

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImage(byte[] value) {
        this.image = value;
    }

    public boolean isSetImage() {
        return (this.image!= null);
    }

    /**
     * Gets the value of the referenceWMS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceWMS() {
        return referenceWMS;
    }

    /**
     * Sets the value of the referenceWMS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceWMS(String value) {
        this.referenceWMS = value;
    }

    public boolean isSetReferenceWMS() {
        return (this.referenceWMS!= null);
    }

    /**
     * Gets the value of the legendAtWeb property.
     * 
     * @return
     *     possible object is
     *     {@link WebReference }
     *     
     */
    public WebReference getLegendAtWeb() {
        return legendAtWeb;
    }

    /**
     * Sets the value of the legendAtWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebReference }
     *     
     */
    public void setLegendAtWeb(WebReference value) {
        this.legendAtWeb = value;
    }

    public boolean isSetLegendAtWeb() {
        return (this.legendAtWeb!= null);
    }

    /**
     * Gets the value of the otherLegend property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherLegend property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherLegend().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegendEntry }
     * 
     * 
     */
    public List<LegendEntry> getOtherLegend() {
        if (otherLegend == null) {
            otherLegend = new ArrayList<LegendEntry>();
        }
        return this.otherLegend;
    }

    public boolean isSetOtherLegend() {
        return ((this.otherLegend!= null)&&(!this.otherLegend.isEmpty()));
    }

    public void unsetOtherLegend() {
        this.otherLegend = null;
    }

    /**
     * Gets the value of the minNS03 property.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getMinNS03() {
        return minNS03;
    }

    /**
     * Sets the value of the minNS03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setMinNS03(PointPropertyType value) {
        this.minNS03 = value;
    }

    public boolean isSetMinNS03() {
        return (this.minNS03 != null);
    }

    /**
     * Gets the value of the maxNS03 property.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getMaxNS03() {
        return maxNS03;
    }

    /**
     * Sets the value of the maxNS03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setMaxNS03(PointPropertyType value) {
        this.maxNS03 = value;
    }

    public boolean isSetMaxNS03() {
        return (this.maxNS03 != null);
    }

    /**
     * Gets the value of the minNS95 property.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getMinNS95() {
        return minNS95;
    }

    /**
     * Sets the value of the minNS95 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setMinNS95(PointPropertyType value) {
        this.minNS95 = value;
    }

    public boolean isSetMinNS95() {
        return (this.minNS95 != null);
    }

    /**
     * Gets the value of the maxNS95 property.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getMaxNS95() {
        return maxNS95;
    }

    /**
     * Sets the value of the maxNS95 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setMaxNS95(PointPropertyType value) {
        this.maxNS95 = value;
    }

    public boolean isSetMaxNS95() {
        return (this.maxNS95 != null);
    }

    /**
     * Gets the value of the layerIndex property.
     * 
     */
    public int getLayerIndex() {
        return layerIndex;
    }

    /**
     * Sets the value of the layerIndex property.
     * 
     */
    public void setLayerIndex(int value) {
        this.layerIndex = value;
    }

    public boolean isSetLayerIndex() {
        return true;
    }

    /**
     * Gets the value of the layerOpacity property.
     * 
     */
    public double getLayerOpacity() {
        return layerOpacity;
    }

    /**
     * Sets the value of the layerOpacity property.
     * 
     */
    public void setLayerOpacity(double value) {
        this.layerOpacity = value;
    }

    public boolean isSetLayerOpacity() {
        return true;
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
