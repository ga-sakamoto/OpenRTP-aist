
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VariableProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VariableProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{}DataProfile">
 *       &lt;sequence>
 *         &lt;element name="ioType" type="{}InOutType"/>
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
@XmlType(name = "VariableProfile", propOrder = {
    "ioType",
    "additionalInfo"
})
@XmlSeeAlso({
    Variable.class
})
public class VariableProfile
    extends DataProfile
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected InOutType ioType;
    protected NVList additionalInfo;

    /**
     * Gets the value of the ioType property.
     * 
     * @return
     *     possible object is
     *     {@link InOutType }
     *     
     */
    public InOutType getIoType() {
        return ioType;
    }

    /**
     * Sets the value of the ioType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InOutType }
     *     
     */
    public void setIoType(InOutType value) {
        this.ioType = value;
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
