//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.18 at 03:16:47 PM CDT 
//


package com.ylc.authorize.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for profileTransactionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="profileTransactionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="profileTransAuthCapture" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransAuthCaptureType"/>
 *         &lt;element name="profileTransAuthOnly" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransAuthOnlyType"/>
 *         &lt;element name="profileTransPriorAuthCapture" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransPriorAuthCaptureType"/>
 *         &lt;element name="profileTransCaptureOnly" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransCaptureOnlyType"/>
 *         &lt;element name="profileTransRefund" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransRefundType"/>
 *         &lt;element name="profileTransVoid" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransVoidType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "profileTransactionType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "profileTransAuthCapture",
    "profileTransAuthOnly",
    "profileTransPriorAuthCapture",
    "profileTransCaptureOnly",
    "profileTransRefund",
    "profileTransVoid"
})
public class ProfileTransactionType {

    protected ProfileTransAuthCaptureType profileTransAuthCapture;
    protected ProfileTransAuthOnlyType profileTransAuthOnly;
    protected ProfileTransPriorAuthCaptureType profileTransPriorAuthCapture;
    protected ProfileTransCaptureOnlyType profileTransCaptureOnly;
    protected ProfileTransRefundType profileTransRefund;
    protected ProfileTransVoidType profileTransVoid;

    /**
     * Gets the value of the profileTransAuthCapture property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTransAuthCaptureType }
     *     
     */
    public ProfileTransAuthCaptureType getProfileTransAuthCapture() {
        return profileTransAuthCapture;
    }

    /**
     * Sets the value of the profileTransAuthCapture property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTransAuthCaptureType }
     *     
     */
    public void setProfileTransAuthCapture(ProfileTransAuthCaptureType value) {
        this.profileTransAuthCapture = value;
    }

    /**
     * Gets the value of the profileTransAuthOnly property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTransAuthOnlyType }
     *     
     */
    public ProfileTransAuthOnlyType getProfileTransAuthOnly() {
        return profileTransAuthOnly;
    }

    /**
     * Sets the value of the profileTransAuthOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTransAuthOnlyType }
     *     
     */
    public void setProfileTransAuthOnly(ProfileTransAuthOnlyType value) {
        this.profileTransAuthOnly = value;
    }

    /**
     * Gets the value of the profileTransPriorAuthCapture property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTransPriorAuthCaptureType }
     *     
     */
    public ProfileTransPriorAuthCaptureType getProfileTransPriorAuthCapture() {
        return profileTransPriorAuthCapture;
    }

    /**
     * Sets the value of the profileTransPriorAuthCapture property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTransPriorAuthCaptureType }
     *     
     */
    public void setProfileTransPriorAuthCapture(ProfileTransPriorAuthCaptureType value) {
        this.profileTransPriorAuthCapture = value;
    }

    /**
     * Gets the value of the profileTransCaptureOnly property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTransCaptureOnlyType }
     *     
     */
    public ProfileTransCaptureOnlyType getProfileTransCaptureOnly() {
        return profileTransCaptureOnly;
    }

    /**
     * Sets the value of the profileTransCaptureOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTransCaptureOnlyType }
     *     
     */
    public void setProfileTransCaptureOnly(ProfileTransCaptureOnlyType value) {
        this.profileTransCaptureOnly = value;
    }

    /**
     * Gets the value of the profileTransRefund property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTransRefundType }
     *     
     */
    public ProfileTransRefundType getProfileTransRefund() {
        return profileTransRefund;
    }

    /**
     * Sets the value of the profileTransRefund property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTransRefundType }
     *     
     */
    public void setProfileTransRefund(ProfileTransRefundType value) {
        this.profileTransRefund = value;
    }

    /**
     * Gets the value of the profileTransVoid property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTransVoidType }
     *     
     */
    public ProfileTransVoidType getProfileTransVoid() {
        return profileTransVoid;
    }

    /**
     * Sets the value of the profileTransVoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTransVoidType }
     *     
     */
    public void setProfileTransVoid(ProfileTransVoidType value) {
        this.profileTransVoid = value;
    }

}