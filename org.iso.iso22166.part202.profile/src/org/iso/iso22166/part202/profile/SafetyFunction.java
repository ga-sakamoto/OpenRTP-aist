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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SafetyFunction complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="SafetyFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="safetyFunctionType" type="{}SafetyType"/>
 *         &lt;element name="validSafetyLevelType" type="{}PLSILType"/>
 *         &lt;element name="eachSafetyLevelPL" type="{}SafeytLevelPL"/>
 *         &lt;element name="eachSafetyLevelSIL" type="{}SafeytLevelSIL"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SafetyFunction", propOrder = {
    "safetyFunctionType",
    "validSafetyLevelType",
    "eachSafetyLevelPL",
    "eachSafetyLevelSIL"
})
public class SafetyFunction {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SafetyType safetyFunctionType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PLSILType validSafetyLevelType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SafeytLevelPL eachSafetyLevelPL;
    @XmlElement(required = true)
    protected String eachSafetyLevelSIL;

    /**
     * safetyFunctionTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link SafetyType }
     *     
     */
    public SafetyType getSafetyFunctionType() {
        return safetyFunctionType;
    }

    /**
     * safetyFunctionTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link SafetyType }
     *     
     */
    public void setSafetyFunctionType(SafetyType value) {
        this.safetyFunctionType = value;
    }

    /**
     * validSafetyLevelTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link PLSILType }
     *     
     */
    public PLSILType getValidSafetyLevelType() {
        return validSafetyLevelType;
    }

    /**
     * validSafetyLevelTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link PLSILType }
     *     
     */
    public void setValidSafetyLevelType(PLSILType value) {
        this.validSafetyLevelType = value;
    }

    /**
     * eachSafetyLevelPLプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link SafeytLevelPL }
     *     
     */
    public SafeytLevelPL getEachSafetyLevelPL() {
        return eachSafetyLevelPL;
    }

    /**
     * eachSafetyLevelPLプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link SafeytLevelPL }
     *     
     */
    public void setEachSafetyLevelPL(SafeytLevelPL value) {
        this.eachSafetyLevelPL = value;
    }

    /**
     * eachSafetyLevelSILプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEachSafetyLevelSIL() {
        return eachSafetyLevelSIL;
    }

    /**
     * eachSafetyLevelSILプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEachSafetyLevelSIL(String value) {
        this.eachSafetyLevelSIL = value;
    }

}
