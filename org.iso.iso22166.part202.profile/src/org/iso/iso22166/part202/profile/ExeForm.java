
package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExeForm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExeForm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exeFileURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shellCmd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="properties" type="{}Property" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ExeForm", propOrder = {
    "exeFileURL",
    "shellCmd",
    "properties",
    "additionalInfo"
})
public class ExeForm {

    @XmlElement(required = true)
    protected String exeFileURL;
    protected String shellCmd;
    protected List<Property> properties;
    protected NVList additionalInfo;

    /**
     * Gets the value of the exeFileURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExeFileURL() {
        return exeFileURL;
    }

    /**
     * Sets the value of the exeFileURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExeFileURL(String value) {
        this.exeFileURL = value;
    }

    /**
     * Gets the value of the shellCmd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShellCmd() {
        return shellCmd;
    }

    /**
     * Sets the value of the shellCmd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShellCmd(String value) {
        this.shellCmd = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the properties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     * 
     * 
     */
    public List<Property> getProperties() {
        if (properties == null) {
            properties = new ArrayList<Property>();
        }
        return this.properties;
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
