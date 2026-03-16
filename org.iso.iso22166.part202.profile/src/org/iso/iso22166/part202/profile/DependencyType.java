
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DependencyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DependencyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OWNER"/>
 *     &lt;enumeration value="OWNED"/>
 *     &lt;enumeration value="OWNEROWNED"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DependencyType")
@XmlEnum
public enum DependencyType {

    OWNER,
    OWNED,
    OWNEROWNED,
    NONE;

    public String value() {
        return name();
    }

    public static DependencyType fromValue(String v) {
        return valueOf(v);
    }

}
