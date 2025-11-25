//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.11.18 時間 11:14:52 AM JST 
//


package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>VariableProfile complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="VariableProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{}DataProfile">
 *       &lt;sequence>
 *         &lt;element name="ioType" type="{}InOutType"/>
 *         &lt;element name="additionalInfo" type="{}NVList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableProfile", propOrder = {
    "ioType",
    "additionalInfo"
})
@XmlSeeAlso({
    Variable.class
})
public class VariableProfile
    extends DataProfile
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected InOutType ioType;
    protected NVList additionalInfo;

    /**
     * ioTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link InOutType }
     *     
     */
    public InOutType getIoType() {
        return ioType;
    }

    /**
     * ioTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link InOutType }
     *     
     */
    public void setIoType(InOutType value) {
        this.ioType = value;
    }

    /**
     * additionalInfoプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link NVList }
     *     
     */
    public NVList getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * additionalInfoプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link NVList }
     *     
     */
    public void setAdditionalInfo(NVList value) {
        this.additionalInfo = value;
    }

}
