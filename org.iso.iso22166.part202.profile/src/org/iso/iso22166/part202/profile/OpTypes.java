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
 * <p>OpTypesのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
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
