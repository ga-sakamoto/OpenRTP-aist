//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.11.18 時間 11:14:52 AM JST 
//


package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>InstanceTypeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
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
