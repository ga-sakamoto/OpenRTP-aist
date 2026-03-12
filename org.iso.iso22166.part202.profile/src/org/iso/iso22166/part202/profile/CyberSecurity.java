
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CyberSecurity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CyberSecurity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="securityType" type="{}SecurityType"/>
 *         &lt;element name="eachSecurityLevel" type="{}SecurityLevel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CyberSecurity", propOrder = {
    "securityType",
    "eachSecurityLevel"
})
public class CyberSecurity {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SecurityType securityType;
    @XmlElement(required = true)
    protected String eachSecurityLevel;

    /**
     * Gets the value of the securityType property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityType }
     *     
     */
    public SecurityType getSecurityType() {
        return securityType;
    }

    /**
     * Sets the value of the securityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityType }
     *     
     */
    public void setSecurityType(SecurityType value) {
        this.securityType = value;
    }

    /**
     * Gets the value of the eachSecurityLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEachSecurityLevel() {
        return eachSecurityLevel;
    }

    /**
     * Sets the value of the eachSecurityLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEachSecurityLevel(String value) {
        this.eachSecurityLevel = value;
    }

}
