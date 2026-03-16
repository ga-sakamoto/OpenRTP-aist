
package org.iso.iso22166.part202.profile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceMethod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="methodName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="argType" type="{}ArgSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="retType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="moType" type="{}MOType"/>
 *         &lt;element name="reqProvType" type="{}ReqProvType"/>
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
@XmlType(name = "ServiceMethod", propOrder = {
    "methodName",
    "argType",
    "retType",
    "moType",
    "reqProvType",
    "additionalInfo"
})
public class ServiceMethod {

    @XmlElement(required = true)
    protected String methodName;
    protected List<ArgSpec> argType;
    @XmlElement(required = true)
    protected String retType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MOType moType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ReqProvType reqProvType;
    protected NVList additionalInfo;

    /**
     * Gets the value of the methodName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Sets the value of the methodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodName(String value) {
        this.methodName = value;
    }

    /**
     * Gets the value of the argType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the argType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArgType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArgSpec }
     * 
     * 
     */
    public List<ArgSpec> getArgType() {
        if (argType == null) {
            argType = new ArrayList<ArgSpec>();
        }
        return this.argType;
    }

    /**
     * Gets the value of the retType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetType() {
        return retType;
    }

    /**
     * Sets the value of the retType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetType(String value) {
        this.retType = value;
    }

    /**
     * Gets the value of the moType property.
     * 
     * @return
     *     possible object is
     *     {@link MOType }
     *     
     */
    public MOType getMoType() {
        return moType;
    }

    /**
     * Sets the value of the moType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MOType }
     *     
     */
    public void setMoType(MOType value) {
        this.moType = value;
    }

    /**
     * Gets the value of the reqProvType property.
     * 
     * @return
     *     possible object is
     *     {@link ReqProvType }
     *     
     */
    public ReqProvType getReqProvType() {
        return reqProvType;
    }

    /**
     * Sets the value of the reqProvType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReqProvType }
     *     
     */
    public void setReqProvType(ReqProvType value) {
        this.reqProvType = value;
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
