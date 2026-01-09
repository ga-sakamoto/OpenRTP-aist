//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.12.27 時間 01:27:43 PM JST 
//


package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ServiceMethod complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="ServiceMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="methodName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="argType" type="{}ArgSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="retType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="moType" type="{}MOType"/>
 *         &lt;element name="reqProvType" type="{}ReqProvType"/>
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
@XmlType(name = "ServiceMethod", propOrder = {
    "methodName",
    "argType",
    "retType",
    "moType",
    "reqProvType",
    "additionalInfo"
})
public class ServiceMethod {

    @XmlElement(required = true)
    protected String methodName;
    protected List<ArgSpec> argType;
    @XmlElement(required = true)
    protected String retType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MOType moType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ReqProvType reqProvType;
    protected NVList additionalInfo;

    /**
     * methodNameプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * methodNameプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodName(String value) {
        this.methodName = value;
    }

    /**
     * Gets the value of the argType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the argType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArgType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArgSpec }
     * 
     * 
     */
    public List<ArgSpec> getArgType() {
        if (argType == null) {
            argType = new ArrayList<ArgSpec>();
        }
        return this.argType;
    }

    /**
     * retTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetType() {
        return retType;
    }

    /**
     * retTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetType(String value) {
        this.retType = value;
    }

    /**
     * moTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link MOType }
     *     
     */
    public MOType getMoType() {
        return moType;
    }

    /**
     * moTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link MOType }
     *     
     */
    public void setMoType(MOType value) {
        this.moType = value;
    }

    /**
     * reqProvTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ReqProvType }
     *     
     */
    public ReqProvType getReqProvType() {
        return reqProvType;
    }

    /**
     * reqProvTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ReqProvType }
     *     
     */
    public void setReqProvType(ReqProvType value) {
        this.reqProvType = value;
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
