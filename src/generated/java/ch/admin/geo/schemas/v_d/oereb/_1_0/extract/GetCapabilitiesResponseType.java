
package ch.admin.geo.schemas.v_d.oereb._1_0.extract;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;


/**
 * <p>Java class for GetCapabilitiesResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCapabilitiesResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="topic" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="municipality" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}MunicipalityCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="flavour" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract}FlavourType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded"/&gt;
 *         &lt;element name="crs" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCapabilitiesResponseType", propOrder = {
    "topic",
    "municipality",
    "flavour",
    "language",
    "crs"
})
public class GetCapabilitiesResponseType {

    protected List<Theme> topic;
    @XmlElement(type = Integer.class)
    @XmlSchemaType(name = "integer")
    protected List<Integer> municipality;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> flavour;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> language;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> crs;

    /**
     * Gets the value of the topic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Theme }
     * 
     * 
     */
    public List<Theme> getTopic() {
        if (topic == null) {
            topic = new ArrayList<Theme>();
        }
        return this.topic;
    }

    public boolean isSetTopic() {
        return ((this.topic!= null)&&(!this.topic.isEmpty()));
    }

    public void unsetTopic() {
        this.topic = null;
    }

    /**
     * Gets the value of the municipality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the municipality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMunicipality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getMunicipality() {
        if (municipality == null) {
            municipality = new ArrayList<Integer>();
        }
        return this.municipality;
    }

    public boolean isSetMunicipality() {
        return ((this.municipality!= null)&&(!this.municipality.isEmpty()));
    }

    public void unsetMunicipality() {
        this.municipality = null;
    }

    /**
     * Gets the value of the flavour property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flavour property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlavour().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFlavour() {
        if (flavour == null) {
            flavour = new ArrayList<String>();
        }
        return this.flavour;
    }

    public boolean isSetFlavour() {
        return ((this.flavour!= null)&&(!this.flavour.isEmpty()));
    }

    public void unsetFlavour() {
        this.flavour = null;
    }

    /**
     * Gets the value of the language property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the language property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLanguage() {
        if (language == null) {
            language = new ArrayList<String>();
        }
        return this.language;
    }

    public boolean isSetLanguage() {
        return ((this.language!= null)&&(!this.language.isEmpty()));
    }

    public void unsetLanguage() {
        this.language = null;
    }

    /**
     * Gets the value of the crs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCrs() {
        if (crs == null) {
            crs = new ArrayList<String>();
        }
        return this.crs;
    }

    public boolean isSetCrs() {
        return ((this.crs!= null)&&(!this.crs.isEmpty()));
    }

    public void unsetCrs() {
        this.crs = null;
    }

}
