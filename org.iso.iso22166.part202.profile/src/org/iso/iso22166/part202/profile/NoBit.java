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
 * <p>NoBitのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="NoBit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BIT16"/>
 *     &lt;enumeration value="BIT32"/>
 *     &lt;enumeration value="BIT64"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NoBit")
@XmlEnum
public enum NoBit {

    @XmlEnumValue("BIT16")
    BIT_16("BIT16"),
    @XmlEnumValue("BIT32")
    BIT_32("BIT32"),
    @XmlEnumValue("BIT64")
    BIT_64("BIT64");
    private final String value;

    NoBit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NoBit fromValue(String v) {
        for (NoBit c: NoBit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
