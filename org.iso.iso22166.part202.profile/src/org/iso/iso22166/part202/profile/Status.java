//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.11.18 時間 11:14:52 AM JST 
//


package org.iso.iso22166.part202.profile;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Status complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="Status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="executionStatus" type="{}ExeStatus"/>
 *         &lt;element name="errorType" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Status", propOrder = {
    "executionStatus",
    "errorType"
})
public class Status {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ExeStatus executionStatus;
    @XmlElement(required = true)
    protected BigInteger errorType;

    /**
     * executionStatusプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ExeStatus }
     *     
     */
    public ExeStatus getExecutionStatus() {
        return executionStatus;
    }

    /**
     * executionStatusプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ExeStatus }
     *     
     */
    public void setExecutionStatus(ExeStatus value) {
        this.executionStatus = value;
    }

    /**
     * errorTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getErrorType() {
        return errorType;
    }

    /**
     * errorTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setErrorType(BigInteger value) {
        this.errorType = value;
    }

}
