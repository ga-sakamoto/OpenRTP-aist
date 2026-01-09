//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.12.27 時間 01:27:43 PM JST 
//


package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>ExecutionType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="ExecutionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opType" type="{}OpTypes"/>
 *         &lt;element name="hardRT" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="timeConstraint" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}hexBinary"/>
 *         &lt;element name="instanceType" type="{}InstanceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExecutionType", propOrder = {
    "opType",
    "hardRT",
    "timeConstraint",
    "priority",
    "instanceType"
})
public class ExecutionType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected OpTypes opType;
    protected boolean hardRT;
    protected double timeConstraint;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] priority;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected InstanceType instanceType;

    /**
     * opTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link OpTypes }
     *     
     */
    public OpTypes getOpType() {
        return opType;
    }

    /**
     * opTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link OpTypes }
     *     
     */
    public void setOpType(OpTypes value) {
        this.opType = value;
    }

    /**
     * hardRTプロパティの値を取得します。
     * 
     */
    public boolean isHardRT() {
        return hardRT;
    }

    /**
     * hardRTプロパティの値を設定します。
     * 
     */
    public void setHardRT(boolean value) {
        this.hardRT = value;
    }

    /**
     * timeConstraintプロパティの値を取得します。
     * 
     */
    public double getTimeConstraint() {
        return timeConstraint;
    }

    /**
     * timeConstraintプロパティの値を設定します。
     * 
     */
    public void setTimeConstraint(double value) {
        this.timeConstraint = value;
    }

    /**
     * priorityプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getPriority() {
        return priority;
    }

    /**
     * priorityプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(byte[] value) {
        this.priority = value;
    }

    /**
     * instanceTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link InstanceType }
     *     
     */
    public InstanceType getInstanceType() {
        return instanceType;
    }

    /**
     * instanceTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link InstanceType }
     *     
     */
    public void setInstanceType(InstanceType value) {
        this.instanceType = value;
    }

}
