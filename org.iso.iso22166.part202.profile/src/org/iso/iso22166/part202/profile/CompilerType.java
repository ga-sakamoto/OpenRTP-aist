
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompilerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompilerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="osName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="verRangeOS" type="{}RangeString"/>
 *         &lt;element name="compilerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="verRangeCompiler" type="{}RangeString"/>
 *         &lt;element name="bitnCPUarch" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CompilerType", propOrder = {
    "osName",
    "verRangeOS",
    "compilerName",
    "verRangeCompiler",
    "bitnCPUarch",
    "additionalInfo"
})
public class CompilerType {

    @XmlElement(required = true)
    protected String osName;
    @XmlElement(required = true)
    protected RangeString verRangeOS;
    @XmlElement(required = true)
    protected String compilerName;
    @XmlElement(required = true)
    protected RangeString verRangeCompiler;
    @XmlElement(required = true)
    protected String bitnCPUarch;
    protected NVList additionalInfo;

    /**
     * Gets the value of the osName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsName() {
        return osName;
    }

    /**
     * Sets the value of the osName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsName(String value) {
        this.osName = value;
    }

    /**
     * Gets the value of the verRangeOS property.
     * 
     * @return
     *     possible object is
     *     {@link RangeString }
     *     
     */
    public RangeString getVerRangeOS() {
        return verRangeOS;
    }

    /**
     * Sets the value of the verRangeOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link RangeString }
     *     
     */
    public void setVerRangeOS(RangeString value) {
        this.verRangeOS = value;
    }

    /**
     * Gets the value of the compilerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompilerName() {
        return compilerName;
    }

    /**
     * Sets the value of the compilerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompilerName(String value) {
        this.compilerName = value;
    }

    /**
     * Gets the value of the verRangeCompiler property.
     * 
     * @return
     *     possible object is
     *     {@link RangeString }
     *     
     */
    public RangeString getVerRangeCompiler() {
        return verRangeCompiler;
    }

    /**
     * Sets the value of the verRangeCompiler property.
     * 
     * @param value
     *     allowed object is
     *     {@link RangeString }
     *     
     */
    public void setVerRangeCompiler(RangeString value) {
        this.verRangeCompiler = value;
    }

    /**
     * Gets the value of the bitnCPUarch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBitnCPUarch() {
        return bitnCPUarch;
    }

    /**
     * Sets the value of the bitnCPUarch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitnCPUarch(String value) {
        this.bitnCPUarch = value;
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
