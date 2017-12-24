
package net.opengis.gml.v_3_2_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterValueGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterValueGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractGeneralParameterValueType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}parameterValue" maxOccurs="unbounded" minOccurs="2"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}group"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterValueGroupType", propOrder = {
    "parameterValue",
    "group"
})
public class ParameterValueGroupType
    extends AbstractGeneralParameterValueType
{

    @XmlElementRef(name = "parameterValue", namespace = "http://www.opengis.net/gml/3.2", type = JAXBElement.class)
    protected List<JAXBElement<AbstractGeneralParameterValuePropertyType>> parameterValue;
    @XmlElementRef(name = "group", namespace = "http://www.opengis.net/gml/3.2", type = JAXBElement.class)
    protected JAXBElement<OperationParameterGroupPropertyType> group;

    /**
     * Gets the value of the parameterValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValuePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValuePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValuePropertyType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<AbstractGeneralParameterValuePropertyType>> getParameterValue() {
        if (parameterValue == null) {
            parameterValue = new ArrayList<JAXBElement<AbstractGeneralParameterValuePropertyType>>();
        }
        return this.parameterValue;
    }

    public boolean isSetParameterValue() {
        return ((this.parameterValue!= null)&&(!this.parameterValue.isEmpty()));
    }

    public void unsetParameterValue() {
        this.parameterValue = null;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperationParameterGroupPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationParameterGroupPropertyType }{@code >}
     *     
     */
    public JAXBElement<OperationParameterGroupPropertyType> getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperationParameterGroupPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationParameterGroupPropertyType }{@code >}
     *     
     */
    public void setGroup(JAXBElement<OperationParameterGroupPropertyType> value) {
        this.group = value;
    }

    public boolean isSetGroup() {
        return (this.group!= null);
    }

}
