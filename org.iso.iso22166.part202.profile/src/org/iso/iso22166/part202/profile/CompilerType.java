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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CompilerType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="CompilerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="osName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="verRangeOS" type="{}RangeString"/>
 *         &lt;element name="compilerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="verRangeCompiler" type="{}RangeString"/>
 *         &lt;element name="bitnCPUarch" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CompilerType", propOrder = {
    "osName",
    "verRangeOS",
    "compilerName",
    "verRangeCompiler",
    "bitnCPUarch",
    "additionalInfo"
})
public class CompilerType {

    @XmlElement(required = true)
    protected String osName;
    @XmlElement(required = true)
    protected RangeString verRangeOS;
    @XmlElement(required = true)
    protected String compilerName;
    @XmlElement(required = true)
    protected RangeString verRangeCompiler;
    @XmlElement(required = true)
    protected String bitnCPUarch;
    protected NVList additionalInfo;

    /**
     * osNameプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsName() {
        return osName;
    }

    /**
     * osNameプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsName(String value) {
        this.osName = value;
    }

    /**
     * verRangeOSプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link RangeString }
     *     
     */
    public RangeString getVerRangeOS() {
        return verRangeOS;
    }

    /**
     * verRangeOSプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link RangeString }
     *     
     */
    public void setVerRangeOS(RangeString value) {
        this.verRangeOS = value;
    }

    /**
     * compilerNameプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompilerName() {
        return compilerName;
    }

    /**
     * compilerNameプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompilerName(String value) {
        this.compilerName = value;
    }

    /**
     * verRangeCompilerプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link RangeString }
     *     
     */
    public RangeString getVerRangeCompiler() {
        return verRangeCompiler;
    }

    /**
     * verRangeCompilerプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link RangeString }
     *     
     */
    public void setVerRangeCompiler(RangeString value) {
        this.verRangeCompiler = value;
    }

    /**
     * bitnCPUarchプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBitnCPUarch() {
        return bitnCPUarch;
    }

    /**
     * bitnCPUarchプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitnCPUarch(String value) {
        this.bitnCPUarch = value;
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
