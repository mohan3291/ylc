//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.18 at 03:16:47 PM CDT 
//


package com.ylc.authorize.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for batchDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="batchDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="batchId" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}numericString"/>
 *         &lt;element name="settlementTimeUTC" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="settlementTimeLocal" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="settlementState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marketType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statistics" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}ArrayOfBatchStatisticType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "batchDetailsType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "batchId",
    "settlementTimeUTC",
    "settlementTimeLocal",
    "settlementState",
    "paymentMethod",
    "marketType",
    "product",
    "statistics"
})
public class BatchDetailsType {

    @XmlElement(required = true)
    protected String batchId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settlementTimeUTC;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settlementTimeLocal;
    @XmlElement(required = true)
    protected String settlementState;
    protected String paymentMethod;
    protected String marketType;
    protected String product;
    protected ArrayOfBatchStatisticType statistics;

    /**
     * Gets the value of the batchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * Sets the value of the batchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchId(String value) {
        this.batchId = value;
    }

    /**
     * Gets the value of the settlementTimeUTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSettlementTimeUTC() {
        return settlementTimeUTC;
    }

    /**
     * Sets the value of the settlementTimeUTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSettlementTimeUTC(XMLGregorianCalendar value) {
        this.settlementTimeUTC = value;
    }

    /**
     * Gets the value of the settlementTimeLocal property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSettlementTimeLocal() {
        return settlementTimeLocal;
    }

    /**
     * Sets the value of the settlementTimeLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSettlementTimeLocal(XMLGregorianCalendar value) {
        this.settlementTimeLocal = value;
    }

    /**
     * Gets the value of the settlementState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementState() {
        return settlementState;
    }

    /**
     * Sets the value of the settlementState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementState(String value) {
        this.settlementState = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * Gets the value of the marketType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketType() {
        return marketType;
    }

    /**
     * Sets the value of the marketType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketType(String value) {
        this.marketType = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the statistics property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBatchStatisticType }
     *     
     */
    public ArrayOfBatchStatisticType getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the statistics property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBatchStatisticType }
     *     
     */
    public void setStatistics(ArrayOfBatchStatisticType value) {
        this.statistics = value;
    }

}
