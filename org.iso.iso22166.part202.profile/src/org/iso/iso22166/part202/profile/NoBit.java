
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NoBit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NoBit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BIT16"/>
 *     &lt;enumeration value="BIT32"/>
 *     &lt;enumeration value="BIT64"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NoBit")
@XmlEnum
public enum NoBit {

    @XmlEnumValue("BIT16")
    BIT_16("BIT16"),
    @XmlEnumValue("BIT32")
    BIT_32("BIT32"),
    @XmlEnumValue("BIT64")
    BIT_64("BIT64");
    private final String value;

    NoBit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NoBit fromValue(String v) {
        for (NoBit c: NoBit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
