
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstanceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InstanceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Singleton"/>
 *     &lt;enumeration value="MultitonStatic"/>
 *     &lt;enumeration value="MultitonComm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InstanceType")
@XmlEnum
public enum InstanceType {

    @XmlEnumValue("Singleton")
    SINGLETON("Singleton"),
    @XmlEnumValue("MultitonStatic")
    MULTITON_STATIC("MultitonStatic"),
    @XmlEnumValue("MultitonComm")
    MULTITON_COMM("MultitonComm");
    private final String value;

    InstanceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InstanceType fromValue(String v) {
        for (InstanceType c: InstanceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
