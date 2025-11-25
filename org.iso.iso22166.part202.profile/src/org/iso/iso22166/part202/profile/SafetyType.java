//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.11.18 時間 11:14:52 AM JST 
//


package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SafetyTypeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
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
