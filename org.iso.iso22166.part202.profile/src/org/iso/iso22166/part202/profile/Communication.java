
package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Communication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Communication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mostTopProtocol" type="{}InfraType" maxOccurs="unbounded"/>
 *         &lt;element name="underlyingProtocol" type="{}DataBus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Communication", propOrder = {
    "mostTopProtocol",
    "underlyingProtocol"
})
public class Communication {

    @XmlElement(required = true)
    protected List<InfraType> mostTopProtocol;
    @XmlElement(required = true)
    protected DataBus underlyingProtocol;

    /**
     * Gets the value of the mostTopProtocol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mostTopProtocol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMostTopProtocol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfraType }
     * 
     * 
     */
    public List<InfraType> getMostTopProtocol() {
        if (mostTopProtocol == null) {
            mostTopProtocol = new ArrayList<InfraType>();
        }
        return this.mostTopProtocol;
    }

    /**
     * Gets the value of the underlyingProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link DataBus }
     *     
     */
    public DataBus getUnderlyingProtocol() {
        return underlyingProtocol;
    }

    /**
     * Sets the value of the underlyingProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataBus }
     *     
     */
    public void setUnderlyingProtocol(DataBus value) {
        this.underlyingProtocol = value;
    }

}
