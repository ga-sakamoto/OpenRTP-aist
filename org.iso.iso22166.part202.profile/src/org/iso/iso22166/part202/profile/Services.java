
package org.iso.iso22166.part202.profile;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Services complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Services">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NoOfBasicService" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="NoOfOptionalService" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="serviceProfile" type="{}ServiceProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Services", propOrder = {
    "noOfBasicService",
    "noOfOptionalService",
    "serviceProfile"
})
public class Services {

    @XmlElement(name = "NoOfBasicService", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger noOfBasicService;
    @XmlElement(name = "NoOfOptionalService", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger noOfOptionalService;
    protected List<ServiceProfile> serviceProfile;

    /**
     * Gets the value of the noOfBasicService property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoOfBasicService() {
        return noOfBasicService;
    }

    /**
     * Sets the value of the noOfBasicService property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoOfBasicService(BigInteger value) {
        this.noOfBasicService = value;
    }

    /**
     * Gets the value of the noOfOptionalService property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoOfOptionalService() {
        return noOfOptionalService;
    }

    /**
     * Sets the value of the noOfOptionalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoOfOptionalService(BigInteger value) {
        this.noOfOptionalService = value;
    }

    /**
     * Gets the value of the serviceProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceProfile }
     * 
     * 
     */
    public List<ServiceProfile> getServiceProfile() {
        if (serviceProfile == null) {
            serviceProfile = new ArrayList<ServiceProfile>();
        }
        return this.serviceProfile;
    }

}
