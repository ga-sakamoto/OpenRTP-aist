
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SIM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SIM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moduleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="examples" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idnType" type="{}IDnType"/>
 *         &lt;element name="properties" type="{}Properties"/>
 *         &lt;element name="ioVariables" type="{}IOVariables"/>
 *         &lt;element name="status" type="{}Status"/>
 *         &lt;element name="services" type="{}Services"/>
 *         &lt;element name="infra" type="{}Infrastructure"/>
 *         &lt;element name="safeSecure" type="{}SafeSecure" minOccurs="0"/>
 *         &lt;element name="modelling" type="{}Modelling" minOccurs="0"/>
 *         &lt;element name="exeForm" type="{}ExecutableForm"/>
 *         &lt;element name="additionalInfo" type="{}NVList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="SIM")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIM", propOrder = {
    "moduleName",
    "description",
    "manufacturer",
    "examples",
    "idnType",
    "properties",
    "ioVariables",
    "status",
    "services",
    "infra",
    "safeSecure",
    "modelling",
    "exeForm",
    "additionalInfo"
})
public class SIM {

    @XmlElement(required = true)
    protected String moduleName;
    protected String description;
    @XmlElement(required = true)
    protected String manufacturer;
    protected String examples;
    @XmlElement(required = true)
    protected IDnType idnType;
    @XmlElement(required = true)
    protected Properties properties;
    @XmlElement(required = true)
    protected IOVariables ioVariables;
    @XmlElement(required = true)
    protected Status status;
    @XmlElement(required = true)
    protected Services services;
    @XmlElement(required = true)
    protected Infrastructure infra;
    protected SafeSecure safeSecure;
    protected Modelling modelling;
    @XmlElement(required = true)
    protected ExecutableForm exeForm;
    protected NVList additionalInfo;

    /**
     * Gets the value of the moduleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets the value of the moduleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the examples property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamples() {
        return examples;
    }

    /**
     * Sets the value of the examples property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamples(String value) {
        this.examples = value;
    }

    /**
     * Gets the value of the idnType property.
     * 
     * @return
     *     possible object is
     *     {@link IDnType }
     *     
     */
    public IDnType getIdnType() {
        return idnType;
    }

    /**
     * Sets the value of the idnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDnType }
     *     
     */
    public void setIdnType(IDnType value) {
        this.idnType = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link Properties }
     *     
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties }
     *     
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the ioVariables property.
     * 
     * @return
     *     possible object is
     *     {@link IOVariables }
     *     
     */
    public IOVariables getIoVariables() {
        return ioVariables;
    }

    /**
     * Sets the value of the ioVariables property.
     * 
     * @param value
     *     allowed object is
     *     {@link IOVariables }
     *     
     */
    public void setIoVariables(IOVariables value) {
        this.ioVariables = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * @return
     *     possible object is
     *     {@link Services }
     *     
     */
    public Services getServices() {
        return services;
    }

    /**
     * Sets the value of the services property.
     * 
     * @param value
     *     allowed object is
     *     {@link Services }
     *     
     */
    public void setServices(Services value) {
        this.services = value;
    }

    /**
     * Gets the value of the infra property.
     * 
     * @return
     *     possible object is
     *     {@link Infrastructure }
     *     
     */
    public Infrastructure getInfra() {
        return infra;
    }

    /**
     * Sets the value of the infra property.
     * 
     * @param value
     *     allowed object is
     *     {@link Infrastructure }
     *     
     */
    public void setInfra(Infrastructure value) {
        this.infra = value;
    }

    /**
     * Gets the value of the safeSecure property.
     * 
     * @return
     *     possible object is
     *     {@link SafeSecure }
     *     
     */
    public SafeSecure getSafeSecure() {
        return safeSecure;
    }

    /**
     * Sets the value of the safeSecure property.
     * 
     * @param value
     *     allowed object is
     *     {@link SafeSecure }
     *     
     */
    public void setSafeSecure(SafeSecure value) {
        this.safeSecure = value;
    }

    /**
     * Gets the value of the modelling property.
     * 
     * @return
     *     possible object is
     *     {@link Modelling }
     *     
     */
    public Modelling getModelling() {
        return modelling;
    }

    /**
     * Sets the value of the modelling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Modelling }
     *     
     */
    public void setModelling(Modelling value) {
        this.modelling = value;
    }

    /**
     * Gets the value of the exeForm property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutableForm }
     *     
     */
    public ExecutableForm getExeForm() {
        return exeForm;
    }

    /**
     * Sets the value of the exeForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutableForm }
     *     
     */
    public void setExeForm(ExecutableForm value) {
        this.exeForm = value;
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
