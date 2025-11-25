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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>IDnType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="IDnType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moduleID" type="{}ModuleID"/>
 *         &lt;element name="informationModelVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="swAspects" type="{}ModuleID" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDnType", propOrder = {
    "moduleID",
    "informationModelVersion",
    "swAspects"
})
public class IDnType {

    @XmlElement(required = true)
    protected ModuleID moduleID;
    @XmlElement(required = true)
    protected String informationModelVersion;
    protected List<ModuleID> swAspects;

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
     * informationModelVersionプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformationModelVersion() {
        return informationModelVersion;
    }

    /**
     * informationModelVersionプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformationModelVersion(String value) {
        this.informationModelVersion = value;
    }

    /**
     * Gets the value of the swAspects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the swAspects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSwAspects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleID }
     * 
     * 
     */
    public List<ModuleID> getSwAspects() {
        if (swAspects == null) {
            swAspects = new ArrayList<ModuleID>();
        }
        return this.swAspects;
    }

}
