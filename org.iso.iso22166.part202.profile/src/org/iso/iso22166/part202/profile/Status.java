
package org.iso.iso22166.part202.profile;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Status complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="executionStatus" type="{}ExeStatus"/>
 *         &lt;element name="errorType" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Status", propOrder = {
    "executionStatus",
    "errorType"
})
public class Status {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ExeStatus executionStatus;
    @XmlElement(required = true)
    protected BigInteger errorType;

    /**
     * Gets the value of the executionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ExeStatus }
     *     
     */
    public ExeStatus getExecutionStatus() {
        return executionStatus;
    }

    /**
     * Sets the value of the executionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExeStatus }
     *     
     */
    public void setExecutionStatus(ExeStatus value) {
        this.executionStatus = value;
    }

    /**
     * Gets the value of the errorType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getErrorType() {
        return errorType;
    }

    /**
     * Sets the value of the errorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setErrorType(BigInteger value) {
        this.errorType = value;
    }

}
