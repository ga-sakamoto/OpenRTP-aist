
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OpTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OpTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PERIODIC"/>
 *     &lt;enumeration value="EVENTDRIVEN"/>
 *     &lt;enumeration value="NONRT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OpTypes")
@XmlEnum
public enum OpTypes {

    PERIODIC,
    EVENTDRIVEN,
    NONRT;

    public String value() {
        return name();
    }

    public static OpTypes fromValue(String v) {
        return valueOf(v);
    }

}
