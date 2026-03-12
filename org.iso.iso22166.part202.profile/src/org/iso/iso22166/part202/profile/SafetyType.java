
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SafetyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SafetyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ESTOP"/>
 *     &lt;enumeration value="PSTOP"/>
 *     &lt;enumeration value="LIMWS"/>
 *     &lt;enumeration value="SRSC"/>
 *     &lt;enumeration value="SRFC"/>
 *     &lt;enumeration value="HCOLA"/>
 *     &lt;enumeration value="STCON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SafetyType")
@XmlEnum
public enum SafetyType {

    ESTOP,
    PSTOP,
    LIMWS,
    SRSC,
    SRFC,
    HCOLA,
    STCON;

    public String value() {
        return name();
    }

    public static SafetyType fromValue(String v) {
        return valueOf(v);
    }

}
