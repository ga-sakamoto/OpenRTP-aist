
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceDescriptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceDescriptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IDL"/>
 *     &lt;enumeration value="XML"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceDescriptionType")
@XmlEnum
public enum ServiceDescriptionType {

    IDL,
    XML;

    public String value() {
        return name();
    }

    public static ServiceDescriptionType fromValue(String v) {
        return valueOf(v);
    }

}
