
package net.opengis.gml.v_3_2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A property with the content model of gml:ShellPropertyType encapsulates a shell to represent a component of a solid boundary.
 * 
 * <p>Java class for ShellPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShellPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}Shell"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShellPropertyType", propOrder = {
    "shell"
})
public class ShellPropertyType {

    @XmlElement(name = "Shell", required = true)
    protected ShellType shell;

    /**
     * Gets the value of the shell property.
     * 
     * @return
     *     possible object is
     *     {@link ShellType }
     *     
     */
    public ShellType getShell() {
        return shell;
    }

    /**
     * Sets the value of the shell property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShellType }
     *     
     */
    public void setShell(ShellType value) {
        this.shell = value;
    }

    public boolean isSetShell() {
        return (this.shell!= null);
    }

}
