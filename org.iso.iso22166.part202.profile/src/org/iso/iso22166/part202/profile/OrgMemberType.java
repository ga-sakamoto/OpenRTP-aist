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
 * <p>OrgMemberType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="OrgMemberType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="member" type="{}ModuleID" maxOccurs="unbounded"/>
 *         &lt;element name="dependency" type="{}DependencyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrgMemberType", propOrder = {
    "member",
    "dependency"
})
public class OrgMemberType {

    @XmlElement(required = true)
    protected List<ModuleID> member;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DependencyType dependency;

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
     * {@link ModuleID }
     * 
     * 
     */
    public List<ModuleID> getMember() {
        if (member == null) {
            member = new ArrayList<ModuleID>();
        }
        return this.member;
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

}
