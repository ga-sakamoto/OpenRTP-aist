
package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Properties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Properties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="osType" type="{}OStype"/>
 *         &lt;element name="libs" type="{}Libraries" minOccurs="0"/>
 *         &lt;element name="organizations" type="{}Organization" minOccurs="0"/>
 *         &lt;element name="compiler" type="{}CompilerType"/>
 *         &lt;element name="exeType" type="{}ExecutionType" maxOccurs="unbounded"/>
 *         &lt;element name="property" type="{}Property" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Properties", propOrder = {
    "osType",
    "libs",
    "organizations",
    "compiler",
    "exeType",
    "property"
})
public class Properties {

    @XmlElement(required = true)
    protected OStype osType;
    protected Libraries libs;
    protected Organization organizations;
    @XmlElement(required = true)
    protected CompilerType compiler;
    @XmlElement(required = true)
    protected List<ExecutionType> exeType;
    protected List<Property> property;

    /**
     * Gets the value of the osType property.
     * 
     * @return
     *     possible object is
     *     {@link OStype }
     *     
     */
    public OStype getOsType() {
        return osType;
    }

    /**
     * Sets the value of the osType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OStype }
     *     
     */
    public void setOsType(OStype value) {
        this.osType = value;
    }

    /**
     * Gets the value of the libs property.
     * 
     * @return
     *     possible object is
     *     {@link Libraries }
     *     
     */
    public Libraries getLibs() {
        return libs;
    }

    /**
     * Sets the value of the libs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Libraries }
     *     
     */
    public void setLibs(Libraries value) {
        this.libs = value;
    }

    /**
     * Gets the value of the organizations property.
     * 
     * @return
     *     possible object is
     *     {@link Organization }
     *     
     */
    public Organization getOrganizations() {
        return organizations;
    }

    /**
     * Sets the value of the organizations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organization }
     *     
     */
    public void setOrganizations(Organization value) {
        this.organizations = value;
    }

    /**
     * Gets the value of the compiler property.
     * 
     * @return
     *     possible object is
     *     {@link CompilerType }
     *     
     */
    public CompilerType getCompiler() {
        return compiler;
    }

    /**
     * Sets the value of the compiler property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompilerType }
     *     
     */
    public void setCompiler(CompilerType value) {
        this.compiler = value;
    }

    /**
     * Gets the value of the exeType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exeType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExeType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExecutionType }
     * 
     * 
     */
    public List<ExecutionType> getExeType() {
        if (exeType == null) {
            exeType = new ArrayList<ExecutionType>();
        }
        return this.exeType;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     * 
     * 
     */
    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }

}
