//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.18 at 03:16:47 PM CDT 
//


package com.ylc.authorize.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReturnedItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReturnedItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnedItem" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}returnedItemType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReturnedItem", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "returnedItem"
})
public class ArrayOfReturnedItem {

    protected List<ReturnedItemType> returnedItem;

    /**
     * Gets the value of the returnedItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnedItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnedItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReturnedItemType }
     * 
     * 
     */
    public List<ReturnedItemType> getReturnedItem() {
        if (returnedItem == null) {
            returnedItem = new ArrayList<ReturnedItemType>();
        }
        return this.returnedItem;
    }

}
