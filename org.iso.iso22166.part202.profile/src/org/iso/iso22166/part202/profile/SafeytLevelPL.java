
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SafeytLevelPL.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SafeytLevelPL">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="n"/>
 *     &lt;enumeration value="a"/>
 *     &lt;enumeration value="b"/>
 *     &lt;enumeration value="c"/>
 *     &lt;enumeration value="d"/>
 *     &lt;enumeration value="e"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SafeytLevelPL")
@XmlEnum
public enum SafeytLevelPL {

    @XmlEnumValue("n")
    N("n"),
    @XmlEnumValue("a")
    A("a"),
    @XmlEnumValue("b")
    B("b"),
    @XmlEnumValue("c")
    C("c"),
    @XmlEnumValue("d")
    D("d"),
    @XmlEnumValue("e")
    E("e");
    private final String value;

    SafeytLevelPL(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SafeytLevelPL fromValue(String v) {
        for (SafeytLevelPL c: SafeytLevelPL.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
