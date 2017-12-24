
package ch.admin.geo.schemas.v_d.oereb._1_0.extract;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ch.admin.geo.schemas.v_d.oereb._1_0.extract package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetExtractByIdResponse_QNAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", "GetExtractByIdResponse");
    private final static QName _GetEGRIDResponse_QNAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", "GetEGRIDResponse");
    private final static QName _GetCapabilitiesResponse_QNAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", "GetCapabilitiesResponse");
    private final static QName _GetEGRIDResponseTypeEgrid_QNAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", "egrid");
    private final static QName _GetEGRIDResponseTypeNumber_QNAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", "number");
    private final static QName _GetEGRIDResponseTypeIdentDN_QNAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", "identDN");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ch.admin.geo.schemas.v_d.oereb._1_0.extract
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetExtractByIdResponseType }
     * 
     */
    public GetExtractByIdResponseType createGetExtractByIdResponseType() {
        return new GetExtractByIdResponseType();
    }

    /**
     * Create an instance of {@link GetExtractByIdResponseType.Embeddable }
     * 
     */
    public GetExtractByIdResponseType.Embeddable createGetExtractByIdResponseTypeEmbeddable() {
        return new GetExtractByIdResponseType.Embeddable();
    }

    /**
     * Create an instance of {@link GetEGRIDResponseType }
     * 
     */
    public GetEGRIDResponseType createGetEGRIDResponseType() {
        return new GetEGRIDResponseType();
    }

    /**
     * Create an instance of {@link GetCapabilitiesResponseType }
     * 
     */
    public GetCapabilitiesResponseType createGetCapabilitiesResponseType() {
        return new GetCapabilitiesResponseType();
    }

    /**
     * Create an instance of {@link GetExtractByIdResponseType.Embeddable.Datasource }
     * 
     */
    public GetExtractByIdResponseType.Embeddable.Datasource createGetExtractByIdResponseTypeEmbeddableDatasource() {
        return new GetExtractByIdResponseType.Embeddable.Datasource();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExtractByIdResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", name = "GetExtractByIdResponse")
    public JAXBElement<GetExtractByIdResponseType> createGetExtractByIdResponse(GetExtractByIdResponseType value) {
        return new JAXBElement<GetExtractByIdResponseType>(_GetExtractByIdResponse_QNAME, GetExtractByIdResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEGRIDResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", name = "GetEGRIDResponse")
    public JAXBElement<GetEGRIDResponseType> createGetEGRIDResponse(GetEGRIDResponseType value) {
        return new JAXBElement<GetEGRIDResponseType>(_GetEGRIDResponse_QNAME, GetEGRIDResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCapabilitiesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", name = "GetCapabilitiesResponse")
    public JAXBElement<GetCapabilitiesResponseType> createGetCapabilitiesResponse(GetCapabilitiesResponseType value) {
        return new JAXBElement<GetCapabilitiesResponseType>(_GetCapabilitiesResponse_QNAME, GetCapabilitiesResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", name = "egrid", scope = GetEGRIDResponseType.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createGetEGRIDResponseTypeEgrid(String value) {
        return new JAXBElement<String>(_GetEGRIDResponseTypeEgrid_QNAME, String.class, GetEGRIDResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", name = "number", scope = GetEGRIDResponseType.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createGetEGRIDResponseTypeNumber(String value) {
        return new JAXBElement<String>(_GetEGRIDResponseTypeNumber_QNAME, String.class, GetEGRIDResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/Extract", name = "identDN", scope = GetEGRIDResponseType.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createGetEGRIDResponseTypeIdentDN(String value) {
        return new JAXBElement<String>(_GetEGRIDResponseTypeIdentDN_QNAME, String.class, GetEGRIDResponseType.class, value);
    }

}
