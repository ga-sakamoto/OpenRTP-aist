
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Power complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Power">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ratedPower" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxPower" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
@XmlType(name = "Power", propOrder = {
    "ratedPower",
    "maxPower",
    "additionalInfo"
})
public class Power {

    protected double ratedPower;
    protected double maxPower;
    protected NVList additionalInfo;

    /**
     * Gets the value of the ratedPower property.
     * 
     */
    public double getRatedPower() {
        return ratedPower;
    }

    /**
     * Sets the value of the ratedPower property.
     * 
     */
    public void setRatedPower(double value) {
        this.ratedPower = value;
    }

    /**
     * Gets the value of the maxPower property.
     * 
     */
    public double getMaxPower() {
        return maxPower;
    }

    /**
     * Sets the value of the maxPower property.
     * 
     */
    public void setMaxPower(double value) {
        this.maxPower = value;
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
