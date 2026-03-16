
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArgSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArgSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valueName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inout" type="{}InOutType"/>
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
@XmlType(name = "ArgSpec", propOrder = {
    "type",
    "valueName",
    "inout",
    "additionalInfo"
})
public class ArgSpec {

    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String valueName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected InOutType inout;
    protected NVList additionalInfo;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the valueName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * Sets the value of the valueName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueName(String value) {
        this.valueName = value;
    }

    /**
     * Gets the value of the inout property.
     * 
     * @return
     *     possible object is
     *     {@link InOutType }
     *     
     */
    public InOutType getInout() {
        return inout;
    }

    /**
     * Sets the value of the inout property.
     * 
     * @param value
     *     allowed object is
     *     {@link InOutType }
     *     
     */
    public void setInout(InOutType value) {
        this.inout = value;
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
