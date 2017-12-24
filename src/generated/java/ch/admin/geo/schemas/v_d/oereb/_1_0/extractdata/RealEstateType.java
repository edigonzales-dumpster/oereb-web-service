
package ch.admin.geo.schemas.v_d.oereb._1_0.extractdata;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RealEstateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RealEstateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RealEstate"/&gt;
 *     &lt;enumeration value="Distinct_and_permanent_rights.BuildingRight"/&gt;
 *     &lt;enumeration value="Distinct_and_permanent_rights.right_to_spring_water"/&gt;
 *     &lt;enumeration value="Distinct_and_permanent_rights.concession"/&gt;
 *     &lt;enumeration value="Distinct_and_permanent_rights.other"/&gt;
 *     &lt;enumeration value="Mineral_rights"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RealEstateType")
@XmlEnum
public enum RealEstateType {

    @XmlEnumValue("RealEstate")
    REAL_ESTATE("RealEstate"),
    @XmlEnumValue("Distinct_and_permanent_rights.BuildingRight")
    DISTINCT_AND_PERMANENT_RIGHTS_BUILDING_RIGHT("Distinct_and_permanent_rights.BuildingRight"),
    @XmlEnumValue("Distinct_and_permanent_rights.right_to_spring_water")
    DISTINCT_AND_PERMANENT_RIGHTS_RIGHT_TO_SPRING_WATER("Distinct_and_permanent_rights.right_to_spring_water"),
    @XmlEnumValue("Distinct_and_permanent_rights.concession")
    DISTINCT_AND_PERMANENT_RIGHTS_CONCESSION("Distinct_and_permanent_rights.concession"),
    @XmlEnumValue("Distinct_and_permanent_rights.other")
    DISTINCT_AND_PERMANENT_RIGHTS_OTHER("Distinct_and_permanent_rights.other"),
    @XmlEnumValue("Mineral_rights")
    MINERAL_RIGHTS("Mineral_rights");
    private final String value;

    RealEstateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RealEstateType fromValue(String v) {
        for (RealEstateType c: RealEstateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
