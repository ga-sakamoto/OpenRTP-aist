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
 * <p>SafeytLevelPLのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="SafeytLevelPL">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="n"/>
 *     &lt;enumeration value="a"/>
 *     &lt;enumeration value="b"/>
 *     &lt;enumeration value="c"/>
 *     &lt;enumeration value="d"/>
 *     &lt;enumeration value="e"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SafeytLevelPL")
@XmlEnum
public enum SafeytLevelPL {

    @XmlEnumValue("n")
    N("n"),
    @XmlEnumValue("a")
    A("a"),
    @XmlEnumValue("b")
    B("b"),
    @XmlEnumValue("c")
    C("c"),
    @XmlEnumValue("d")
    D("d"),
    @XmlEnumValue("e")
    E("e");
    private final String value;

    SafeytLevelPL(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SafeytLevelPL fromValue(String v) {
        for (SafeytLevelPL c: SafeytLevelPL.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
