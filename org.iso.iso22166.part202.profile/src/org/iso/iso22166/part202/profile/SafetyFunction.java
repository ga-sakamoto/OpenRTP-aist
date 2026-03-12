
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SafetyFunction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SafetyFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="safetyFunctionType" type="{}SafetyType"/>
 *         &lt;element name="validSafetyLevelType" type="{}PLSILType"/>
 *         &lt;element name="eachSafetyLevelPL" type="{}SafeytLevelPL"/>
 *         &lt;element name="eachSafetyLevelSIL" type="{}SafeytLevelSIL"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SafetyFunction", propOrder = {
    "safetyFunctionType",
    "validSafetyLevelType",
    "eachSafetyLevelPL",
    "eachSafetyLevelSIL"
})
public class SafetyFunction {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SafetyType safetyFunctionType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PLSILType validSafetyLevelType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SafeytLevelPL eachSafetyLevelPL;
    @XmlElement(required = true)
    protected String eachSafetyLevelSIL;

    /**
     * Gets the value of the safetyFunctionType property.
     * 
     * @return
     *     possible object is
     *     {@link SafetyType }
     *     
     */
    public SafetyType getSafetyFunctionType() {
        return safetyFunctionType;
    }

    /**
     * Sets the value of the safetyFunctionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SafetyType }
     *     
     */
    public void setSafetyFunctionType(SafetyType value) {
        this.safetyFunctionType = value;
    }

    /**
     * Gets the value of the validSafetyLevelType property.
     * 
     * @return
     *     possible object is
     *     {@link PLSILType }
     *     
     */
    public PLSILType getValidSafetyLevelType() {
        return validSafetyLevelType;
    }

    /**
     * Sets the value of the validSafetyLevelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PLSILType }
     *     
     */
    public void setValidSafetyLevelType(PLSILType value) {
        this.validSafetyLevelType = value;
    }

    /**
     * Gets the value of the eachSafetyLevelPL property.
     * 
     * @return
     *     possible object is
     *     {@link SafeytLevelPL }
     *     
     */
    public SafeytLevelPL getEachSafetyLevelPL() {
        return eachSafetyLevelPL;
    }

    /**
     * Sets the value of the eachSafetyLevelPL property.
     * 
     * @param value
     *     allowed object is
     *     {@link SafeytLevelPL }
     *     
     */
    public void setEachSafetyLevelPL(SafeytLevelPL value) {
        this.eachSafetyLevelPL = value;
    }

    /**
     * Gets the value of the eachSafetyLevelSIL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEachSafetyLevelSIL() {
        return eachSafetyLevelSIL;
    }

    /**
     * Sets the value of the eachSafetyLevelSIL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEachSafetyLevelSIL(String value) {
        this.eachSafetyLevelSIL = value;
    }

}
