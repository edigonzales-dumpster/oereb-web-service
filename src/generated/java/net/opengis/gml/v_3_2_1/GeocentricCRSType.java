
package net.opengis.gml.v_3_2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeocentricCRSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeocentricCRSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractCRSType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}usesCartesianCS"/&gt;
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}usesSphericalCS"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}usesGeodeticDatum"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeocentricCRSType", propOrder = {
    "usesCartesianCS",
    "usesSphericalCS",
    "usesGeodeticDatum"
})
public class GeocentricCRSType
    extends AbstractCRSType
{

    protected CartesianCSPropertyType usesCartesianCS;
    protected SphericalCSPropertyType usesSphericalCS;
    @XmlElement(required = true)
    protected GeodeticDatumPropertyType usesGeodeticDatum;

    /**
     * Gets the value of the usesCartesianCS property.
     * 
     * @return
     *     possible object is
     *     {@link CartesianCSPropertyType }
     *     
     */
    public CartesianCSPropertyType getUsesCartesianCS() {
        return usesCartesianCS;
    }

    /**
     * Sets the value of the usesCartesianCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link CartesianCSPropertyType }
     *     
     */
    public void setUsesCartesianCS(CartesianCSPropertyType value) {
        this.usesCartesianCS = value;
    }

    public boolean isSetUsesCartesianCS() {
        return (this.usesCartesianCS!= null);
    }

    /**
     * Gets the value of the usesSphericalCS property.
     * 
     * @return
     *     possible object is
     *     {@link SphericalCSPropertyType }
     *     
     */
    public SphericalCSPropertyType getUsesSphericalCS() {
        return usesSphericalCS;
    }

    /**
     * Sets the value of the usesSphericalCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link SphericalCSPropertyType }
     *     
     */
    public void setUsesSphericalCS(SphericalCSPropertyType value) {
        this.usesSphericalCS = value;
    }

    public boolean isSetUsesSphericalCS() {
        return (this.usesSphericalCS!= null);
    }

    /**
     * Gets the value of the usesGeodeticDatum property.
     * 
     * @return
     *     possible object is
     *     {@link GeodeticDatumPropertyType }
     *     
     */
    public GeodeticDatumPropertyType getUsesGeodeticDatum() {
        return usesGeodeticDatum;
    }

    /**
     * Sets the value of the usesGeodeticDatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeodeticDatumPropertyType }
     *     
     */
    public void setUsesGeodeticDatum(GeodeticDatumPropertyType value) {
        this.usesGeodeticDatum = value;
    }

    public boolean isSetUsesGeodeticDatum() {
        return (this.usesGeodeticDatum!= null);
    }

}
