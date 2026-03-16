
package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ExecutionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExecutionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opType" type="{}OpTypes"/>
 *         &lt;element name="hardRT" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="timeConstraint" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}hexBinary"/>
 *         &lt;element name="instanceType" type="{}InstanceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExecutionType", propOrder = {
    "opType",
    "hardRT",
    "timeConstraint",
    "priority",
    "instanceType"
})
public class ExecutionType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected OpTypes opType;
    protected boolean hardRT;
    protected double timeConstraint;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] priority;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected InstanceType instanceType;

    /**
     * Gets the value of the opType property.
     * 
     * @return
     *     possible object is
     *     {@link OpTypes }
     *     
     */
    public OpTypes getOpType() {
        return opType;
    }

    /**
     * Sets the value of the opType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpTypes }
     *     
     */
    public void setOpType(OpTypes value) {
        this.opType = value;
    }

    /**
     * Gets the value of the hardRT property.
     * 
     */
    public boolean isHardRT() {
        return hardRT;
    }

    /**
     * Sets the value of the hardRT property.
     * 
     */
    public void setHardRT(boolean value) {
        this.hardRT = value;
    }

    /**
     * Gets the value of the timeConstraint property.
     * 
     */
    public double getTimeConstraint() {
        return timeConstraint;
    }

    /**
     * Sets the value of the timeConstraint property.
     * 
     */
    public void setTimeConstraint(double value) {
        this.timeConstraint = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(byte[] value) {
        this.priority = value;
    }

    /**
     * Gets the value of the instanceType property.
     * 
     * @return
     *     possible object is
     *     {@link InstanceType }
     *     
     */
    public InstanceType getInstanceType() {
        return instanceType;
    }

    /**
     * Sets the value of the instanceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstanceType }
     *     
     */
    public void setInstanceType(InstanceType value) {
        this.instanceType = value;
    }

}
