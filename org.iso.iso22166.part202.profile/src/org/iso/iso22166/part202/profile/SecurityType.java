
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecurityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SecurityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HU_IA"/>
 *     &lt;enumeration value="SD_IA"/>
 *     &lt;enumeration value="ACNT_MGT"/>
 *     &lt;enumeration value="ID_MGT"/>
 *     &lt;enumeration value="AUTH_MGT"/>
 *     &lt;enumeration value="WIRELEE_MGT"/>
 *     &lt;enumeration value="PW_AUTH"/>
 *     &lt;enumeration value="PK_CERT"/>
 *     &lt;enumeration value="STR_PK_AUTH"/>
 *     &lt;enumeration value="LOGIN_NO"/>
 *     &lt;enumeration value="ACC_UNTRUST_NET"/>
 *     &lt;enumeration value="AUTHORIZE"/>
 *     &lt;enumeration value="WIRELESS_USE"/>
 *     &lt;enumeration value="SESS_LOCK"/>
 *     &lt;enumeration value="SESS_TERM"/>
 *     &lt;enumeration value="SECC_CNTR"/>
 *     &lt;enumeration value="AUDT_EVT"/>
 *     &lt;enumeration value="TIMESTM"/>
 *     &lt;enumeration value="NON_REP"/>
 *     &lt;enumeration value="COMM_INTG"/>
 *     &lt;enumeration value="PROT_MALI_CODE"/>
 *     &lt;enumeration value="SECUR_VERIFY"/>
 *     &lt;enumeration value="SW_INTGT"/>
 *     &lt;enumeration value="INPUT_VALD"/>
 *     &lt;enumeration value="DET_OUT"/>
 *     &lt;enumeration value="ERR_HNDL"/>
 *     &lt;enumeration value="SESS_ INTGT"/>
 *     &lt;enumeration value="INFO_CONFI"/>
 *     &lt;enumeration value="INFO_PERS"/>
 *     &lt;enumeration value="CRYTO"/>
 *     &lt;enumeration value="RSTIC_FLOW"/>
 *     &lt;enumeration value="DoS"/>
 *     &lt;enumeration value="RESOU_MGT"/>
 *     &lt;enumeration value="CNTR_RECOV_RECON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SecurityType")
@XmlEnum
public enum SecurityType {

    HU_IA("HU_IA"),
    SD_IA("SD_IA"),
    ACNT_MGT("ACNT_MGT"),
    ID_MGT("ID_MGT"),
    AUTH_MGT("AUTH_MGT"),
    WIRELEE_MGT("WIRELEE_MGT"),
    PW_AUTH("PW_AUTH"),
    PK_CERT("PK_CERT"),
    STR_PK_AUTH("STR_PK_AUTH"),
    LOGIN_NO("LOGIN_NO"),
    ACC_UNTRUST_NET("ACC_UNTRUST_NET"),
    AUTHORIZE("AUTHORIZE"),
    WIRELESS_USE("WIRELESS_USE"),
    SESS_LOCK("SESS_LOCK"),
    SESS_TERM("SESS_TERM"),
    SECC_CNTR("SECC_CNTR"),
    AUDT_EVT("AUDT_EVT"),
    TIMESTM("TIMESTM"),
    NON_REP("NON_REP"),
    COMM_INTG("COMM_INTG"),
    PROT_MALI_CODE("PROT_MALI_CODE"),
    SECUR_VERIFY("SECUR_VERIFY"),
    SW_INTGT("SW_INTGT"),
    INPUT_VALD("INPUT_VALD"),
    DET_OUT("DET_OUT"),
    ERR_HNDL("ERR_HNDL"),
    @XmlEnumValue("SESS_ INTGT")
    SESS_INTGT("SESS_ INTGT"),
    INFO_CONFI("INFO_CONFI"),
    INFO_PERS("INFO_PERS"),
    CRYTO("CRYTO"),
    RSTIC_FLOW("RSTIC_FLOW"),
    @XmlEnumValue("DoS")
    DO_S("DoS"),
    RESOU_MGT("RESOU_MGT"),
    CNTR_RECOV_RECON("CNTR_RECOV_RECON");
    private final String value;

    SecurityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SecurityType fromValue(String v) {
        for (SecurityType c: SecurityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
