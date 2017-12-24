
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.CurvePropertyType;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;


/**
 * <p>Java class for Geometry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Geometry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="Point" type="{http://www.opengis.net/gml/3.2}PointPropertyType"/&gt;
 *           &lt;element name="Line" type="{http://www.opengis.net/gml/3.2}CurvePropertyType"/&gt;
 *           &lt;element name="Surface" type="{http://www.opengis.net/gml/3.2}SurfacePropertyType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Lawstatus" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Lawstatus"/&gt;
 *         &lt;element name="MetadataOfGeographicalBaseData" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
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
@XmlType(name = "Geometry", propOrder = {
    "point",
    "line",
    "surface",
    "lawstatus",
    "metadataOfGeographicalBaseData",
    "responsibleOffice",
    "extensions"
})
public class Geometry {

    @XmlElement(name = "Point")
    protected PointPropertyType point;
    @XmlElement(name = "Line")
    protected CurvePropertyType line;
    @XmlElement(name = "Surface")
    protected SurfacePropertyType surface;
    @XmlElement(name = "Lawstatus", required = true)
    protected Lawstatus lawstatus;
    @XmlElement(name = "MetadataOfGeographicalBaseData")
    @XmlSchemaType(name = "anyURI")
    protected String metadataOfGeographicalBaseData;
    @XmlElement(name = "ResponsibleOffice", required = true)
    protected Office responsibleOffice;
    protected Extensions extensions;

    /**
     * Gets the value of the point property.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getPoint() {
        return point;
    }

    /**
     * Sets the value of the point property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setPoint(PointPropertyType value) {
        this.point = value;
    }

    public boolean isSetPoint() {
        return (this.point!= null);
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link CurvePropertyType }
     *     
     */
    public CurvePropertyType getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurvePropertyType }
     *     
     */
    public void setLine(CurvePropertyType value) {
        this.line = value;
    }

    public boolean isSetLine() {
        return (this.line!= null);
    }

    /**
     * Gets the value of the surface property.
     * 
     * @return
     *     possible object is
     *     {@link SurfacePropertyType }
     *     
     */
    public SurfacePropertyType getSurface() {
        return surface;
    }

    /**
     * Sets the value of the surface property.
     * 
     * @param value
     *     allowed object is
     *     {@link SurfacePropertyType }
     *     
     */
    public void setSurface(SurfacePropertyType value) {
        this.surface = value;
    }

    public boolean isSetSurface() {
        return (this.surface!= null);
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
