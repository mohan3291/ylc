package com.ylc.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylc.model.Customer;
import com.ylc.model.CustomerLine;
import com.ylc.model.CustomerLinePaymentDetail;
import com.ylc.model.Invoice;
import com.ylc.model.User;
import com.ylc.service.CustermerService;
import com.ylc.service.CustomerLinePaymentDetailService;
import com.ylc.service.CustomerLineService;
import com.ylc.service.UserService;


/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
    private CustermerService customerService;
	@Autowired
    public CustomerLinePaymentDetailService customerLinePaymentDetailService;
	@Autowired
    private UserService userService;
	
	@Autowired
	private CustomerLineService customerLineService;
    @RequestMapping("/layout")
    public String getInvoicePartialPage() {
        return "invoice/layout";
    }
    
    @RequestMapping("/invoiceForUser")
    public @ResponseBody List<Invoice> getInvoice() {
   	 List<com.ylc.model.CustomerLinePaymentDetail> cutLinePayDetails=new ArrayList<com.ylc.model.CustomerLinePaymentDetail>();
   	List<Invoice> returnList=new ArrayList<Invoice>();
    	cutLinePayDetails=customerLinePaymentDetailService.getCustomerLinePaymentDetailByCustomer(getCustomer());
    	
    	Invoice invoice =null;
    	for(CustomerLinePaymentDetail payDetails:cutLinePayDetails){
    		invoice = new Invoice();
    	  //  invoice.setAdd(payDetails.get);
		    invoice.setAgent("");
		    invoice.setAmount("$"+payDetails.getPaymentAmount());
		    invoice.setDelete("N/A");
		    invoice.setEdit("N/A");
		    
		    invoice.setPaidToNumber(payDetails.getLast4DigitsOfCard());
		    invoice.setPaymentDate(""+payDetails.getCreatedDate());
		    invoice.setPaymentID(""+payDetails.getPaymentConformationCode());
		    CustomerLine customerLines =customerLineService.getCustomerLineByLineID(payDetails.getCustomerLine());
		    invoice.setPaidToNumber(customerLines.getLocalLineNumber());
		    invoice.setNoOfMin(""+customerLines.getPrepaidMinutes());
		    returnList.add(invoice);
		    
    	}
        return returnList;
    }
    
    private Customer getCustomer(){
    	String userID=SecurityContextHolder.getContext().getAuthentication().getName();
    	Customer customer=new Customer();
    	customer.setCustomerID(Integer.parseInt(userID));    
    	try {
			customer=customerService.getCustomerById(customer);
		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
    	return customer;
    }
}
