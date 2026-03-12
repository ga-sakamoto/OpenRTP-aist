
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PLSILType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PLSILType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PL"/>
 *     &lt;enumeration value="SIL"/>
 *     &lt;enumeration value="BOTH"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PLSILType")
@XmlEnum
public enum PLSILType {

    PL,
    SIL,
    BOTH,
    NONE;

    public String value() {
        return name();
    }

    public static PLSILType fromValue(String v) {
        return valueOf(v);
    }

}
