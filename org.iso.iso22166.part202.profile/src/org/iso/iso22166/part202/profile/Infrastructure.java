
package org.iso.iso22166.part202.profile;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Infrastructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Infrastructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="power" type="{}Power"/>
 *         &lt;element name="noBuses" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="dataBus" type="{}DataBus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dbType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalInfo" type="{}NVList" minOccurs="0"/>
 *         &lt;element name="comms" type="{}Communication" maxOccurs="unbounded"/>
 *         &lt;element name="database" type="{}InfraType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="middleware" type="{}InfraType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Infrastructure", propOrder = {
    "power",
    "noBuses",
    "dataBus",
    "dbType",
    "ipCode",
    "additionalInfo",
    "comms",
    "database",
    "middleware"
})
public class Infrastructure {

    @XmlElement(required = true)
    protected Power power;
    @XmlElement(required = true)
    protected BigInteger noBuses;
    protected List<DataBus> dataBus;
    protected String dbType;
    protected String ipCode;
    protected NVList additionalInfo;
    @XmlElement(required = true)
    protected List<Communication> comms;
    protected List<InfraType> database;
    protected List<InfraType> middleware;

    /**
     * Gets the value of the power property.
     * 
     * @return
     *     possible object is
     *     {@link Power }
     *     
     */
    public Power getPower() {
        return power;
    }

    /**
     * Sets the value of the power property.
     * 
     * @param value
     *     allowed object is
     *     {@link Power }
     *     
     */
    public void setPower(Power value) {
        this.power = value;
    }

    /**
     * Gets the value of the noBuses property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoBuses() {
        return noBuses;
    }

    /**
     * Sets the value of the noBuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoBuses(BigInteger value) {
        this.noBuses = value;
    }

    /**
     * Gets the value of the dataBus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataBus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataBus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataBus }
     * 
     * 
     */
    public List<DataBus> getDataBus() {
        if (dataBus == null) {
            dataBus = new ArrayList<DataBus>();
        }
        return this.dataBus;
    }

    /**
     * Gets the value of the dbType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * Sets the value of the dbType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbType(String value) {
        this.dbType = value;
    }

    /**
     * Gets the value of the ipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpCode() {
        return ipCode;
    }

    /**
     * Sets the value of the ipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpCode(String value) {
        this.ipCode = value;
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

    /**
     * Gets the value of the comms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Communication }
     * 
     * 
     */
    public List<Communication> getComms() {
        if (comms == null) {
            comms = new ArrayList<Communication>();
        }
        return this.comms;
    }

    /**
     * Gets the value of the database property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the database property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatabase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfraType }
     * 
     * 
     */
    public List<InfraType> getDatabase() {
        if (database == null) {
            database = new ArrayList<InfraType>();
        }
        return this.database;
    }

    /**
     * Gets the value of the middleware property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the middleware property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMiddleware().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfraType }
     * 
     * 
     */
    public List<InfraType> getMiddleware() {
        if (middleware == null) {
            middleware = new ArrayList<InfraType>();
        }
        return this.middleware;
    }

}
