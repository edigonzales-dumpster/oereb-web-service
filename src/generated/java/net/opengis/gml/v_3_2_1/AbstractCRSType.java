
package net.opengis.gml.v_3_2_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AbstractCRSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractCRSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}IdentifiedObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}domainOfValidity" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}scope" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCRSType", propOrder = {
    "domainOfValidity",
    "scope"
})
@XmlSeeAlso({
    CompoundCRSType.class,
    GeodeticCRSType.class,
    VerticalCRSType.class,
    AbstractGeneralDerivedCRSType.class,
    EngineeringCRSType.class,
    ImageCRSType.class,
    TemporalCRSType.class,
    GeographicCRSType.class,
    GeocentricCRSType.class
})
public abstract class AbstractCRSType
    extends IdentifiedObjectType
{

    protected List<DomainOfValidity> domainOfValidity;
    @XmlElement(required = true)
    protected List<String> scope;

    /**
     * Gets the value of the domainOfValidity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domainOfValidity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomainOfValidity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomainOfValidity }
     * 
     * 
     */
    public List<DomainOfValidity> getDomainOfValidity() {
        if (domainOfValidity == null) {
            domainOfValidity = new ArrayList<DomainOfValidity>();
        }
        return this.domainOfValidity;
    }

    public boolean isSetDomainOfValidity() {
        return ((this.domainOfValidity!= null)&&(!this.domainOfValidity.isEmpty()));
    }

    public void unsetDomainOfValidity() {
        this.domainOfValidity = null;
    }

    /**
     * Gets the value of the scope property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scope property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScope().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getScope() {
        if (scope == null) {
            scope = new ArrayList<String>();
        }
        return this.scope;
    }

    public boolean isSetScope() {
        return ((this.scope!= null)&&(!this.scope.isEmpty()));
    }

    public void unsetScope() {
        this.scope = null;
    }

}
