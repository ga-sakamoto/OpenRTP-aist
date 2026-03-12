
package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the id property.
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
     * Sets the value of the id property.
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
     * Gets the value of the ifURL property.
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
     * Sets the value of the ifURL property.
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
     * Gets the value of the pvType property.
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
     * Sets the value of the pvType property.
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
     * Gets the value of the moType property.
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
     * Sets the value of the moType property.
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
     * Gets the value of the moduleID property.
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
     * Sets the value of the moduleID property.
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
     * Gets the value of the additionalInfo property.
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
     * Sets the value of the additionalInfo property.
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
     * Gets the value of the descriptionType property.
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
     * Sets the value of the descriptionType property.
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
