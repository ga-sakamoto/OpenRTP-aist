//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.11.18 時間 11:14:52 AM JST 
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
 * <p>ServiceProfile complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="ServiceProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ifURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="methodList" type="{}ServiceMethod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pvType" type="{}PhysicalVirtual "/>
 *         &lt;element name="moType" type="{}MOType"/>
 *         &lt;element name="moduleID" type="{}ModuleID" minOccurs="0"/>
 *         &lt;element name="additionalInfo" type="{}NVList" minOccurs="0"/>
 *         &lt;element name="descriptionType" type="{}ServiceDescriptionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceProfile", propOrder = {
    "id",
    "ifURL",
    "methodList",
    "pvType",
    "moType",
    "moduleID",
    "additionalInfo",
    "descriptionType"
})
public class ServiceProfile {

    @XmlElement(required = true)
    protected String id;
    protected String ifURL;
    protected List<ServiceMethod> methodList;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PhysicalVirtual_0020 pvType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MOType moType;
    protected ModuleID moduleID;
    protected NVList additionalInfo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ServiceDescriptionType descriptionType;

    /**
     * idプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * idプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * ifURLプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfURL() {
        return ifURL;
    }

    /**
     * ifURLプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfURL(String value) {
        this.ifURL = value;
    }

    /**
     * Gets the value of the methodList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the methodList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceMethod }
     * 
     * 
     */
    public List<ServiceMethod> getMethodList() {
        if (methodList == null) {
            methodList = new ArrayList<ServiceMethod>();
        }
        return this.methodList;
    }

    /**
     * pvTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link PhysicalVirtual_0020 }
     *     
     */
    public PhysicalVirtual_0020 getPvType() {
        return pvType;
    }

    /**
     * pvTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalVirtual_0020 }
     *     
     */
    public void setPvType(PhysicalVirtual_0020 value) {
        this.pvType = value;
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
     * moduleIDプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ModuleID }
     *     
     */
    public ModuleID getModuleID() {
        return moduleID;
    }

    /**
     * moduleIDプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleID }
     *     
     */
    public void setModuleID(ModuleID value) {
        this.moduleID = value;
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

    /**
     * descriptionTypeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ServiceDescriptionType }
     *     
     */
    public ServiceDescriptionType getDescriptionType() {
        return descriptionType;
    }

    /**
     * descriptionTypeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDescriptionType }
     *     
     */
    public void setDescriptionType(ServiceDescriptionType value) {
        this.descriptionType = value;
    }

}
