//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.12.27 時間 01:27:43 PM JST 
//


package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PhysicalVirtual のJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalVirtual ">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Physical"/>
 *     &lt;enumeration value="Virtual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhysicalVirtual ")
@XmlEnum
public enum PhysicalVirtual_0020 {

    @XmlEnumValue("Physical")
    PHYSICAL("Physical"),
    @XmlEnumValue("Virtual")
    VIRTUAL("Virtual");
    private final String value;

    PhysicalVirtual_0020(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PhysicalVirtual_0020 fromValue(String v) {
        for (PhysicalVirtual_0020 c: PhysicalVirtual_0020 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
