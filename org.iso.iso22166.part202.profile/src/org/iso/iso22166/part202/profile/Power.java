//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.11.18 時間 11:14:52 AM JST 
//


package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Power complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="Power">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ratedPower" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxPower" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="additionalInfo" type="{}NVList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Power", propOrder = {
    "ratedPower",
    "maxPower",
    "additionalInfo"
})
public class Power {

    protected double ratedPower;
    protected double maxPower;
    protected NVList additionalInfo;

    /**
     * ratedPowerプロパティの値を取得します。
     * 
     */
    public double getRatedPower() {
        return ratedPower;
    }

    /**
     * ratedPowerプロパティの値を設定します。
     * 
     */
    public void setRatedPower(double value) {
        this.ratedPower = value;
    }

    /**
     * maxPowerプロパティの値を取得します。
     * 
     */
    public double getMaxPower() {
        return maxPower;
    }

    /**
     * maxPowerプロパティの値を設定します。
     * 
     */
    public void setMaxPower(double value) {
        this.maxPower = value;
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
