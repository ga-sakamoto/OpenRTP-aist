
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExeStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExeStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE"/>
 *     &lt;enumeration value="IDLE"/>
 *     &lt;enumeration value="EXECUTING"/>
 *     &lt;enumeration value="DESTRUCTED"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExeStatus")
@XmlEnum
public enum ExeStatus {

    CREATE,
    IDLE,
    EXECUTING,
    DESTRUCTED,
    ERROR;

    public String value() {
        return name();
    }

    public static ExeStatus fromValue(String v) {
        return valueOf(v);
    }

}
