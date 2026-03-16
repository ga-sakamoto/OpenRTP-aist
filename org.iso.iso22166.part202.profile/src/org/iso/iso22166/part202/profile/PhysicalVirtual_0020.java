
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalVirtual .
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalVirtual ">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Physical"/>
 *     &lt;enumeration value="Virtual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhysicalVirtual ")
@XmlEnum
public enum PhysicalVirtual_0020 {

    @XmlEnumValue("Physical")
    PHYSICAL("Physical"),
    @XmlEnumValue("Virtual")
    VIRTUAL("Virtual");
    private final String value;

    PhysicalVirtual_0020(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PhysicalVirtual_0020 fromValue(String v) {
        for (PhysicalVirtual_0020 c: PhysicalVirtual_0020 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
