//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2025.11.18 時間 11:14:52 AM JST 
//


package org.iso.iso22166.part202.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SIM complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
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
 *         &lt;element name="execForm" type="{}ExecutableForm"/>
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
    "execForm",
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
    protected ExecutableForm execForm;
    protected NVList additionalInfo;

    /**
     * moduleNameプロパティの値を取得します。
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
     * moduleNameプロパティの値を設定します。
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
     * descriptionプロパティの値を取得します。
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
     * descriptionプロパティの値を設定します。
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
     * manufacturerプロパティの値を取得します。
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
     * manufacturerプロパティの値を設定します。
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
     * examplesプロパティの値を取得します。
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
     * examplesプロパティの値を設定します。
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
     * idnTypeプロパティの値を取得します。
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
     * idnTypeプロパティの値を設定します。
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
     * propertiesプロパティの値を取得します。
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
     * propertiesプロパティの値を設定します。
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
     * ioVariablesプロパティの値を取得します。
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
     * ioVariablesプロパティの値を設定します。
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
     * statusプロパティの値を取得します。
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
     * statusプロパティの値を設定します。
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
     * servicesプロパティの値を取得します。
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
     * servicesプロパティの値を設定します。
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
     * infraプロパティの値を取得します。
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
     * infraプロパティの値を設定します。
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
     * safeSecureプロパティの値を取得します。
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
     * safeSecureプロパティの値を設定します。
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
     * modellingプロパティの値を取得します。
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
     * modellingプロパティの値を設定します。
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
     * execFormプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ExecutableForm }
     *     
     */
    public ExecutableForm getExecForm() {
        return execForm;
    }

    /**
     * execFormプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutableForm }
     *     
     */
    public void setExecForm(ExecutableForm value) {
        this.execForm = value;
    }

    /**
     * additionalInfoプロパティの値を取得します。
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
     * additionalInfoプロパティの値を設定します。
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
