//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.26 at 04:41:10 PM CDT 
//


package com.ylc.peer.listaval.request.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HDR">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="User" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Pass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Payload">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="REQTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Listavail">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CPN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="MAXAVAIL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hdr",
    "payload"
})
@XmlRootElement(name = "PEER")
public class PEER {

    @XmlElement(name = "HDR", required = true)
    protected PEER.HDR hdr;
    @XmlElement(name = "Payload", required = true)
    protected PEER.Payload payload;

    /**
     * Gets the value of the hdr property.
     * 
     * @return
     *     possible object is
     *     {@link PEER.HDR }
     *     
     */
    public PEER.HDR getHDR() {
        return hdr;
    }

    /**
     * Sets the value of the hdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PEER.HDR }
     *     
     */
    public void setHDR(PEER.HDR value) {
        this.hdr = value;
    }

    /**
     * Gets the value of the payload property.
     * 
     * @return
     *     possible object is
     *     {@link PEER.Payload }
     *     
     */
    public PEER.Payload getPayload() {
        return payload;
    }

    /**
     * Sets the value of the payload property.
     * 
     * @param value
     *     allowed object is
     *     {@link PEER.Payload }
     *     
     */
    public void setPayload(PEER.Payload value) {
        this.payload = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="User" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Pass" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "user",
        "pass"
    })
    public static class HDR {

        @XmlElement(name = "User", required = true)
        protected String user;
        @XmlElement(name = "Pass", required = true)
        protected String pass;

        /**
         * Gets the value of the user property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUser() {
            return user;
        }

        /**
         * Sets the value of the user property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUser(String value) {
            this.user = value;
        }

        /**
         * Gets the value of the pass property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPass() {
            return pass;
        }

        /**
         * Sets the value of the pass property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPass(String value) {
            this.pass = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="REQTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Listavail">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CPN" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="MAXAVAIL" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "reqtype",
        "listavail"
    })
    public static class Payload {

        @XmlElement(name = "REQTYPE", required = true)
        protected String reqtype;
        @XmlElement(name = "Listavail", required = true)
        protected PEER.Payload.Listavail listavail;

        /**
         * Gets the value of the reqtype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREQTYPE() {
            return reqtype;
        }

        /**
         * Sets the value of the reqtype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREQTYPE(String value) {
            this.reqtype = value;
        }

        /**
         * Gets the value of the listavail property.
         * 
         * @return
         *     possible object is
         *     {@link PEER.Payload.Listavail }
         *     
         */
        public PEER.Payload.Listavail getListavail() {
            return listavail;
        }

        /**
         * Sets the value of the listavail property.
         * 
         * @param value
         *     allowed object is
         *     {@link PEER.Payload.Listavail }
         *     
         */
        public void setListavail(PEER.Payload.Listavail value) {
            this.listavail = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="CPN" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="MAXAVAIL" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "cpn",
            "maxavail"
        })
        public static class Listavail {

            @XmlElement(name = "CPN", required = true)
            protected String cpn;
            @XmlElement(name = "MAXAVAIL")
            protected int maxavail;

            /**
             * Gets the value of the cpn property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCPN() {
                return cpn;
            }

            /**
             * Sets the value of the cpn property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCPN(String value) {
                this.cpn = value;
            }

            /**
             * Gets the value of the maxavail property.
             * 
             */
            public int getMAXAVAIL() {
                return maxavail;
            }

            /**
             * Sets the value of the maxavail property.
             * 
             */
            public void setMAXAVAIL(int value) {
                this.maxavail = value;
            }

        }

    }

}