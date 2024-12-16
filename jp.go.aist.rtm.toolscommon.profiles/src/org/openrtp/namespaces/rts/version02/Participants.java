
package org.openrtp.namespaces.rts.version02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for participants complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="participants">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Participant" type="{http://www.openrtp.org/namespaces/rts}target_component"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "participants", propOrder = {
    "participant"
})
public class Participants {

    @XmlElement(name = "Participant", required = true)
    protected TargetComponent participant;

    /**
     * Gets the value of the participant property.
     * 
     * @return
     *     possible object is
     *     {@link TargetComponent }
     *     
     */
    public TargetComponent getParticipant() {
        return participant;
    }

    /**
     * Sets the value of the participant property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetComponent }
     *     
     */
    public void setParticipant(TargetComponent value) {
        this.participant = value;
    }

}
