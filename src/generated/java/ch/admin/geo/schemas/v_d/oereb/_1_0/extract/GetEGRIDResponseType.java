
package ch.admin.geo.schemas.v_d.oereb._1_0.extract;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetEGRIDResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEGRIDResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="egrid" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="identDN" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEGRIDResponseType", propOrder = {
    "egridAndNumberAndIdentDN"
})
@XmlRootElement(name="GetEGRIDResponse")
public class GetEGRIDResponseType {

    @XmlElementRefs({
        @XmlElementRef(name = "egrid", namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "number", namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "identDN", namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> egridAndNumberAndIdentDN;

    /**
     * Gets the value of the egridAndNumberAndIdentDN property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the egridAndNumberAndIdentDN property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEgridAndNumberAndIdentDN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getEgridAndNumberAndIdentDN() {
        if (egridAndNumberAndIdentDN == null) {
            egridAndNumberAndIdentDN = new ArrayList<JAXBElement<String>>();
        }
        return this.egridAndNumberAndIdentDN;
    }

    public boolean isSetEgridAndNumberAndIdentDN() {
        return ((this.egridAndNumberAndIdentDN!= null)&&(!this.egridAndNumberAndIdentDN.isEmpty()));
    }

    public void unsetEgridAndNumberAndIdentDN() {
        this.egridAndNumberAndIdentDN = null;
    }

}
