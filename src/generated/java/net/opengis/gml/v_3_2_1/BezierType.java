
package net.opengis.gml.v_3_2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BezierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BezierType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.opengis.net/gml/3.2}BSplineType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *             &lt;element ref="{http://www.opengis.net/gml/3.2}pos"/&gt;
 *             &lt;element ref="{http://www.opengis.net/gml/3.2}pointProperty"/&gt;
 *             &lt;element ref="{http://www.opengis.net/gml/3.2}pointRep"/&gt;
 *           &lt;/choice&gt;
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}posList"/&gt;
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}coordinates"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="degree" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *         &lt;element name="knot" type="{http://www.opengis.net/gml/3.2}KnotPropertyType" maxOccurs="2" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="interpolation" type="{http://www.opengis.net/gml/3.2}CurveInterpolationType" fixed="polynomialSpline" /&gt;
 *       &lt;attribute name="isPolynomial" type="{http://www.w3.org/2001/XMLSchema}boolean" fixed="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BezierType")
public class BezierType
    extends BSplineType
{


}
