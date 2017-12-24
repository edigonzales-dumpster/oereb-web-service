
package ch.admin.geo.schemas.v_d.oereb._1_0.extract;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Extract;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;


/**
 * <p>Java class for GetExtractByIdResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetExtractByIdResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="embeddable"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="cadasterState" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                     &lt;element name="cadasterOrganisationName" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
 *                     &lt;element name="dataownerNameCadastralSurveying" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
 *                     &lt;element name="transferFromSourceCadastralSurveying" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                     &lt;element name="datasource" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="topic" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme"/&gt;
 *                               &lt;element name="dataownerName" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
 *                               &lt;element name="transferFromSource" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="pdf" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element ref="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Extract"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetExtractByIdResponseType", propOrder = {
    "embeddable",
    "extract"
})
@XmlRootElement(name="GetExtractByIdResponse")
public class GetExtractByIdResponseType {

    protected GetExtractByIdResponseType.Embeddable embeddable;
    @XmlElement(name = "Extract", namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData")
    protected Extract extract;

    /**
     * Gets the value of the embeddable property.
     * 
     * @return
     *     possible object is
     *     {@link GetExtractByIdResponseType.Embeddable }
     *     
     */
    public GetExtractByIdResponseType.Embeddable getEmbeddable() {
        return embeddable;
    }

    /**
     * Sets the value of the embeddable property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetExtractByIdResponseType.Embeddable }
     *     
     */
    public void setEmbeddable(GetExtractByIdResponseType.Embeddable value) {
        this.embeddable = value;
    }

    public boolean isSetEmbeddable() {
        return (this.embeddable!= null);
    }

    /**
     * Gets the value of the extract property.
     * 
     * @return
     *     possible object is
     *     {@link Extract }
     *     
     */
    public Extract getExtract() {
        return extract;
    }

    /**
     * Sets the value of the extract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extract }
     *     
     */
    public void setExtract(Extract value) {
        this.extract = value;
    }

    public boolean isSetExtract() {
        return (this.extract!= null);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="cadasterState" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="cadasterOrganisationName" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
     *         &lt;element name="dataownerNameCadastralSurveying" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
     *         &lt;element name="transferFromSourceCadastralSurveying" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="datasource" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="topic" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme"/&gt;
     *                   &lt;element name="dataownerName" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
     *                   &lt;element name="transferFromSource" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="pdf" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cadasterState",
        "cadasterOrganisationName",
        "dataownerNameCadastralSurveying",
        "transferFromSourceCadastralSurveying",
        "datasource",
        "pdf"
    })
    public static class Embeddable {

        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar cadasterState;
        @XmlElement(required = true)
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        @XmlSchemaType(name = "normalizedString")
        protected String cadasterOrganisationName;
        @XmlElement(required = true)
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        @XmlSchemaType(name = "normalizedString")
        protected String dataownerNameCadastralSurveying;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar transferFromSourceCadastralSurveying;
        protected List<GetExtractByIdResponseType.Embeddable.Datasource> datasource;
        @XmlElement(required = true)
        protected byte[] pdf;

        /**
         * Gets the value of the cadasterState property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCadasterState() {
            return cadasterState;
        }

        /**
         * Sets the value of the cadasterState property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCadasterState(XMLGregorianCalendar value) {
            this.cadasterState = value;
        }

        public boolean isSetCadasterState() {
            return (this.cadasterState!= null);
        }

        /**
         * Gets the value of the cadasterOrganisationName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCadasterOrganisationName() {
            return cadasterOrganisationName;
        }

        /**
         * Sets the value of the cadasterOrganisationName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCadasterOrganisationName(String value) {
            this.cadasterOrganisationName = value;
        }

        public boolean isSetCadasterOrganisationName() {
            return (this.cadasterOrganisationName!= null);
        }

        /**
         * Gets the value of the dataownerNameCadastralSurveying property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataownerNameCadastralSurveying() {
            return dataownerNameCadastralSurveying;
        }

        /**
         * Sets the value of the dataownerNameCadastralSurveying property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataownerNameCadastralSurveying(String value) {
            this.dataownerNameCadastralSurveying = value;
        }

        public boolean isSetDataownerNameCadastralSurveying() {
            return (this.dataownerNameCadastralSurveying!= null);
        }

        /**
         * Gets the value of the transferFromSourceCadastralSurveying property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTransferFromSourceCadastralSurveying() {
            return transferFromSourceCadastralSurveying;
        }

        /**
         * Sets the value of the transferFromSourceCadastralSurveying property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTransferFromSourceCadastralSurveying(XMLGregorianCalendar value) {
            this.transferFromSourceCadastralSurveying = value;
        }

        public boolean isSetTransferFromSourceCadastralSurveying() {
            return (this.transferFromSourceCadastralSurveying!= null);
        }

        /**
         * Gets the value of the datasource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the datasource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDatasource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetExtractByIdResponseType.Embeddable.Datasource }
         * 
         * 
         */
        public List<GetExtractByIdResponseType.Embeddable.Datasource> getDatasource() {
            if (datasource == null) {
                datasource = new ArrayList<GetExtractByIdResponseType.Embeddable.Datasource>();
            }
            return this.datasource;
        }

        public boolean isSetDatasource() {
            return ((this.datasource!= null)&&(!this.datasource.isEmpty()));
        }

        public void unsetDatasource() {
            this.datasource = null;
        }

        /**
         * Gets the value of the pdf property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getPdf() {
            return pdf;
        }

        /**
         * Sets the value of the pdf property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setPdf(byte[] value) {
            this.pdf = value;
        }

        public boolean isSetPdf() {
            return (this.pdf!= null);
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="topic" type="{http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData}Theme"/&gt;
         *         &lt;element name="dataownerName" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
         *         &lt;element name="transferFromSource" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "topic",
            "dataownerName",
            "transferFromSource"
        })
        public static class Datasource {

            @XmlElement(required = true)
            protected Theme topic;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            @XmlSchemaType(name = "normalizedString")
            protected String dataownerName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar transferFromSource;

            /**
             * Gets the value of the topic property.
             * 
             * @return
             *     possible object is
             *     {@link Theme }
             *     
             */
            public Theme getTopic() {
                return topic;
            }

            /**
             * Sets the value of the topic property.
             * 
             * @param value
             *     allowed object is
             *     {@link Theme }
             *     
             */
            public void setTopic(Theme value) {
                this.topic = value;
            }

            public boolean isSetTopic() {
                return (this.topic!= null);
            }

            /**
             * Gets the value of the dataownerName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataownerName() {
                return dataownerName;
            }

            /**
             * Sets the value of the dataownerName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataownerName(String value) {
                this.dataownerName = value;
            }

            public boolean isSetDataownerName() {
                return (this.dataownerName!= null);
            }

            /**
             * Gets the value of the transferFromSource property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getTransferFromSource() {
                return transferFromSource;
            }

            /**
             * Sets the value of the transferFromSource property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setTransferFromSource(XMLGregorianCalendar value) {
                this.transferFromSource = value;
            }

            public boolean isSetTransferFromSource() {
                return (this.transferFromSource!= null);
            }

        }

    }

}
