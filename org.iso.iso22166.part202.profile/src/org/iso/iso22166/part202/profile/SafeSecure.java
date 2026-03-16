
package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SafeSecure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SafeSecure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="overallValidSafetyLevelType" type="{}PLSILType"/>
 *         &lt;element name="overallSafetyLevelPL" type="{}SafeytLevelPL"/>
 *         &lt;element name="overallSafetyLevelSIL" type="{}SafeytLevelSIL"/>
 *         &lt;element name="overallPhySecurityLevel" type="{}SecurityLevel"/>
 *         &lt;element name="overallCybSecurityLevel" type="{}SecurityLevel"/>
 *         &lt;element name="inSafetyLevel" type="{}SafetyFunction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inCybSecurityLevel" type="{}CyberSecurity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="additionalInfo" type="{}NVList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SafeSecure", propOrder = {
    "overallValidSafetyLevelType",
    "overallSafetyLevelPL",
    "overallSafetyLevelSIL",
    "overallPhySecurityLevel",
    "overallCybSecurityLevel",
    "inSafetyLevel",
    "inCybSecurityLevel",
    "additionalInfo"
})
public class SafeSecure {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PLSILType overallValidSafetyLevelType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SafeytLevelPL overallSafetyLevelPL;
    @XmlElement(required = true)
    protected String overallSafetyLevelSIL;
    @XmlElement(required = true)
    protected String overallPhySecurityLevel;
    @XmlElement(required = true)
    protected String overallCybSecurityLevel;
    protected List<SafetyFunction> inSafetyLevel;
    protected List<CyberSecurity> inCybSecurityLevel;
    protected NVList additionalInfo;

    /**
     * Gets the value of the overallValidSafetyLevelType property.
     * 
     * @return
     *     possible object is
     *     {@link PLSILType }
     *     
     */
    public PLSILType getOverallValidSafetyLevelType() {
        return overallValidSafetyLevelType;
    }

    /**
     * Sets the value of the overallValidSafetyLevelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PLSILType }
     *     
     */
    public void setOverallValidSafetyLevelType(PLSILType value) {
        this.overallValidSafetyLevelType = value;
    }

    /**
     * Gets the value of the overallSafetyLevelPL property.
     * 
     * @return
     *     possible object is
     *     {@link SafeytLevelPL }
     *     
     */
    public SafeytLevelPL getOverallSafetyLevelPL() {
        return overallSafetyLevelPL;
    }

    /**
     * Sets the value of the overallSafetyLevelPL property.
     * 
     * @param value
     *     allowed object is
     *     {@link SafeytLevelPL }
     *     
     */
    public void setOverallSafetyLevelPL(SafeytLevelPL value) {
        this.overallSafetyLevelPL = value;
    }

    /**
     * Gets the value of the overallSafetyLevelSIL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverallSafetyLevelSIL() {
        return overallSafetyLevelSIL;
    }

    /**
     * Sets the value of the overallSafetyLevelSIL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverallSafetyLevelSIL(String value) {
        this.overallSafetyLevelSIL = value;
    }

    /**
     * Gets the value of the overallPhySecurityLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverallPhySecurityLevel() {
        return overallPhySecurityLevel;
    }

    /**
     * Sets the value of the overallPhySecurityLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverallPhySecurityLevel(String value) {
        this.overallPhySecurityLevel = value;
    }

    /**
     * Gets the value of the overallCybSecurityLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverallCybSecurityLevel() {
        return overallCybSecurityLevel;
    }

    /**
     * Sets the value of the overallCybSecurityLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverallCybSecurityLevel(String value) {
        this.overallCybSecurityLevel = value;
    }

    /**
     * Gets the value of the inSafetyLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inSafetyLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInSafetyLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SafetyFunction }
     * 
     * 
     */
    public List<SafetyFunction> getInSafetyLevel() {
        if (inSafetyLevel == null) {
            inSafetyLevel = new ArrayList<SafetyFunction>();
        }
        return this.inSafetyLevel;
    }

    /**
     * Gets the value of the inCybSecurityLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inCybSecurityLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInCybSecurityLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CyberSecurity }
     * 
     * 
     */
    public List<CyberSecurity> getInCybSecurityLevel() {
        if (inCybSecurityLevel == null) {
            inCybSecurityLevel = new ArrayList<CyberSecurity>();
        }
        return this.inCybSecurityLevel;
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

}
