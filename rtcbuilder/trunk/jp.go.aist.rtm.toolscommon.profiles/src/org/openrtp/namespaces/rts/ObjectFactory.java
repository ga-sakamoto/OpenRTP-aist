//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.05.14 at 04:20:56 �ߌ� JST 
//


package org.openrtp.namespaces.rts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.openrtp.namespaces.rts package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RTSystemProfile_QNAME = new QName("http://www.openrtp.org/namespaces/rts", "RTSystemProfile");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.openrtp.namespaces.rts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Participant }
     * 
     */
    public Participant createParticipant() {
        return new Participant();
    }

    /**
     * Create an instance of {@link ServiceportConnector }
     * 
     */
    public ServiceportConnector createServiceportConnector() {
        return new ServiceportConnector();
    }

    /**
     * Create an instance of {@link Serviceport }
     * 
     */
    public Serviceport createServiceport() {
        return new Serviceport();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link TargetComponentExt }
     * 
     */
    public TargetComponentExt createTargetComponentExt() {
        return new TargetComponentExt();
    }

    /**
     * Create an instance of {@link ExecutionContext }
     * 
     */
    public ExecutionContext createExecutionContext() {
        return new ExecutionContext();
    }

    /**
     * Create an instance of {@link PrecedingComponent }
     * 
     */
    public PrecedingComponent createPrecedingComponent() {
        return new PrecedingComponent();
    }

    /**
     * Create an instance of {@link RtsProfileExt }
     * 
     */
    public RtsProfileExt createRtsProfileExt() {
        return new RtsProfileExt();
    }

    /**
     * Create an instance of {@link DataportConnectorExt }
     * 
     */
    public DataportConnectorExt createDataportConnectorExt() {
        return new DataportConnectorExt();
    }

    /**
     * Create an instance of {@link ServiceportConnectorExt }
     * 
     */
    public ServiceportConnectorExt createServiceportConnectorExt() {
        return new ServiceportConnectorExt();
    }

    /**
     * Create an instance of {@link DataportConnector }
     * 
     */
    public DataportConnector createDataportConnector() {
        return new DataportConnector();
    }

    /**
     * Create an instance of {@link ConfigurationSet }
     * 
     */
    public ConfigurationSet createConfigurationSet() {
        return new ConfigurationSet();
    }

    /**
     * Create an instance of {@link Component }
     * 
     */
    public Component createComponent() {
        return new Component();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link ConfigurationData }
     * 
     */
    public ConfigurationData createConfigurationData() {
        return new ConfigurationData();
    }

    /**
     * Create an instance of {@link Startup }
     * 
     */
    public Startup createStartup() {
        return new Startup();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

    /**
     * Create an instance of {@link TargetPort }
     * 
     */
    public TargetPort createTargetPort() {
        return new TargetPort();
    }

    /**
     * Create an instance of {@link TargetPortExt }
     * 
     */
    public TargetPortExt createTargetPortExt() {
        return new TargetPortExt();
    }

    /**
     * Create an instance of {@link ConditionExt }
     * 
     */
    public ConditionExt createConditionExt() {
        return new ConditionExt();
    }

    /**
     * Create an instance of {@link ComponentExt }
     * 
     */
    public ComponentExt createComponentExt() {
        return new ComponentExt();
    }

    /**
     * Create an instance of {@link TargetComponent }
     * 
     */
    public TargetComponent createTargetComponent() {
        return new TargetComponent();
    }

    /**
     * Create an instance of {@link Dataport }
     * 
     */
    public Dataport createDataport() {
        return new Dataport();
    }

    /**
     * Create an instance of {@link RtsProfile }
     * 
     */
    public RtsProfile createRtsProfile() {
        return new RtsProfile();
    }

    /**
     * Create an instance of {@link ExecutionContextExt }
     * 
     */
    public ExecutionContextExt createExecutionContextExt() {
        return new ExecutionContextExt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RtsProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.openrtp.org/namespaces/rts", name = "RTSystemProfile")
    public JAXBElement<RtsProfile> createRTSystemProfile(RtsProfile value) {
        return new JAXBElement<RtsProfile>(_RTSystemProfile_QNAME, RtsProfile.class, null, value);
    }

}
