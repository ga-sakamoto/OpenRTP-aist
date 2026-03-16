
package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the informationModelVersion property.
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
     * Sets the value of the informationModelVersion property.
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
