
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MOType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MOType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MANDATORY"/>
 *     &lt;enumeration value="OPTIONAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MOType")
@XmlEnum
public enum MOType {

    MANDATORY,
    OPTIONAL;

    public String value() {
        return name();
    }

    public static MOType fromValue(String v) {
        return valueOf(v);
    }

}
