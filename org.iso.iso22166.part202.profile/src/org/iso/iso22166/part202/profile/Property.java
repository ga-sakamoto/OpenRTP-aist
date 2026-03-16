
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Property complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Property">
 *   &lt;complexContent>
 *     &lt;extension base="{}DataProfile">
 *       &lt;sequence>
 *         &lt;element name="immutable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="additionalInfo" type="{}NVList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Property", propOrder = {
    "immutable",
    "value",
    "additionalInfo"
})
public class Property
    extends DataProfile
{

    protected boolean immutable;
    @XmlElement(required = true)
    protected String value;
    protected NVList additionalInfo;

    /**
     * Gets the value of the immutable property.
     * 
     */
    public boolean isImmutable() {
        return immutable;
    }

    /**
     * Sets the value of the immutable property.
     * 
     */
    public void setImmutable(boolean value) {
        this.immutable = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
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
