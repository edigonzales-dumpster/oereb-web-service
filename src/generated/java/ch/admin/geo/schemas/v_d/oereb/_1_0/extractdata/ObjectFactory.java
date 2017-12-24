
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ch.admin.geo.schemas.v_d.oereb._1_0.extractdata package. 
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

    private final static QName _Extract_QNAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData", "Extract");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ch.admin.geo.schemas.v_d.oereb._1_0.extractdata
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Extensions }
     * 
     */
    public Extensions createExtensions() {
        return new Extensions();
    }

    /**
     * Create an instance of {@link Extract }
     * 
     */
    public Extract createExtract() {
        return new Extract();
    }

    /**
     * Create an instance of {@link WebReference }
     * 
     */
    public WebReference createWebReference() {
        return new WebReference();
    }

    /**
     * Create an instance of {@link Lawstatus }
     * 
     */
    public Lawstatus createLawstatus() {
        return new Lawstatus();
    }

    /**
     * Create an instance of {@link Theme }
     * 
     */
    public Theme createTheme() {
        return new Theme();
    }

    /**
     * Create an instance of {@link LocalisedUri }
     * 
     */
    public LocalisedUri createLocalisedUri() {
        return new LocalisedUri();
    }

    /**
     * Create an instance of {@link MultilingualUri }
     * 
     */
    public MultilingualUri createMultilingualUri() {
        return new MultilingualUri();
    }

    /**
     * Create an instance of {@link LocalisedText }
     * 
     */
    public LocalisedText createLocalisedText() {
        return new LocalisedText();
    }

    /**
     * Create an instance of {@link LocalisedMText }
     * 
     */
    public LocalisedMText createLocalisedMText() {
        return new LocalisedMText();
    }

    /**
     * Create an instance of {@link MultilingualText }
     * 
     */
    public MultilingualText createMultilingualText() {
        return new MultilingualText();
    }

    /**
     * Create an instance of {@link MultilingualMText }
     * 
     */
    public MultilingualMText createMultilingualMText() {
        return new MultilingualMText();
    }

    /**
     * Create an instance of {@link Office }
     * 
     */
    public Office createOffice() {
        return new Office();
    }

    /**
     * Create an instance of {@link DocumentBase }
     * 
     */
    public DocumentBase createDocumentBase() {
        return new DocumentBase();
    }

    /**
     * Create an instance of {@link Glossary }
     * 
     */
    public Glossary createGlossary() {
        return new Glossary();
    }

    /**
     * Create an instance of {@link ExclusionOfLiability }
     * 
     */
    public ExclusionOfLiability createExclusionOfLiability() {
        return new ExclusionOfLiability();
    }

    /**
     * Create an instance of {@link LegendEntry }
     * 
     */
    public LegendEntry createLegendEntry() {
        return new LegendEntry();
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link Geometry }
     * 
     */
    public Geometry createGeometry() {
        return new Geometry();
    }

    /**
     * Create an instance of {@link Map }
     * 
     */
    public Map createMap() {
        return new Map();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link RestrictionOnLandownership }
     * 
     */
    public RestrictionOnLandownership createRestrictionOnLandownership() {
        return new RestrictionOnLandownership();
    }

    /**
     * Create an instance of {@link RealEstateDPR }
     * 
     */
    public RealEstateDPR createRealEstateDPR() {
        return new RealEstateDPR();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Extract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.geo.admin.ch/V_D/OeREB/1.0/ExtractData", name = "Extract")
    public JAXBElement<Extract> createExtract(Extract value) {
        return new JAXBElement<Extract>(_Extract_QNAME, Extract.class, null, value);
    }

}
