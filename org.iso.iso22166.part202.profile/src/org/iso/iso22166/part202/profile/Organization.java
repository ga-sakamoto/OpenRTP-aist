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
 * <p>Organization complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="Organization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="owner" type="{}ModuleID"/>
 *         &lt;element name="dependency" type="{}DependencyType"/>
 *         &lt;element name="member" type="{}OrgMemberType" maxOccurs="unbounded"/>
 *         &lt;element name="additionalinfo" type="{}NVList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Organization", propOrder = {
    "owner",
    "dependency",
    "member",
    "additionalinfo"
})
public class Organization {

    @XmlElement(required = true)
    protected ModuleID owner;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DependencyType dependency;
    @XmlElement(required = true)
    protected List<OrgMemberType> member;
    protected NVList additionalinfo;

    /**
     * ownerプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ModuleID }
     *     
     */
    public ModuleID getOwner() {
        return owner;
    }

    /**
     * ownerプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleID }
     *     
     */
    public void setOwner(ModuleID value) {
        this.owner = value;
    }

    /**
     * dependencyプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link DependencyType }
     *     
     */
    public DependencyType getDependency() {
        return dependency;
    }

    /**
     * dependencyプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link DependencyType }
     *     
     */
    public void setDependency(DependencyType value) {
        this.dependency = value;
    }

    /**
     * Gets the value of the member property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the member property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrgMemberType }
     * 
     * 
     */
    public List<OrgMemberType> getMember() {
        if (member == null) {
            member = new ArrayList<OrgMemberType>();
        }
        return this.member;
    }

    /**
     * additionalinfoプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link NVList }
     *     
     */
    public NVList getAdditionalinfo() {
        return additionalinfo;
    }

    /**
     * additionalinfoプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link NVList }
     *     
     */
    public void setAdditionalinfo(NVList value) {
        this.additionalinfo = value;
    }

}
