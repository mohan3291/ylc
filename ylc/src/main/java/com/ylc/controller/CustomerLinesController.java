package com.ylc.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylc.model.Customer;
import com.ylc.model.CustomerLine;
import com.ylc.model.FacilityNumberPool;
import com.ylc.model.InMateNumberDetails;
import com.ylc.model.TeliphoneLine;
import com.ylc.model.User;
import com.ylc.service.CustermerService;
import com.ylc.service.CustomerLineService;
import com.ylc.service.FacilityNumberPoolService;
import com.ylc.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/customerlines")
public class CustomerLinesController {
	
	@Autowired
	private CustomerLineService customerLineService;
	
	@Autowired
    private CustermerService customerService;
	
	@Autowired
	FacilityNumberPoolService facilityNumberPoolService;
	
	
	@Autowired
    private UserService userService;
	
    @RequestMapping("/layout")
    public String getLinesPartialPage() {
        return "customerlines/layout";
    }
    
    @RequestMapping("/customerLinesList")
    public @ResponseBody List<TeliphoneLine> customerLines(HttpServletRequest  request) {
    	
    	
    	return getCustLineList();
        }
    
    
    private List<TeliphoneLine> getCustLineList(){
    		List<TeliphoneLine> lineList=new ArrayList<TeliphoneLine>();
    	
    	List<CustomerLine> customerLines =customerLineService.getCustomerLineByCustomer(getCustomer());
    	TeliphoneLine teliphoneLine=null;
    	for(CustomerLine customerLine:customerLines){
    		teliphoneLine=new TeliphoneLine();
    		
    		teliphoneLine.setLineID(customerLine.getCustomerLineID());
    		teliphoneLine.setActivation(customerLine.getCreatedDate().toString());
    		if(customerLine.getInMate()!=null && customerLine.getInMate().getFacilityLocation()!=null){
    			teliphoneLine.setFacility(customerLine.getInMate().getFacilityLocation().getFacilityName());
    			teliphoneLine.setInmateName(customerLine.getInMate().getInmateFirstName()+" "+customerLine.getInMate().getInmateLastName());
    			teliphoneLine.setBop(customerLine.getInMate().getBopNumber());
    		
    		}
    		//teliphoneLine.setDestCountry(customerLine.get);
    		teliphoneLine.setMinutesRemaining(customerLine.getPrepaidMinutes());
    		teliphoneLine.setNumber(customerLine.getLocalLineNumber());
    		teliphoneLine.setRoutingNumber(customerLine.getDestinationLineNumber());
    		/*teliphoneLine.getService(customerLine.get)*/
    		if(customerLine.getActive()==1)
    			teliphoneLine.setStatus("Active");
    		else
    			teliphoneLine.setStatus("In Active");
    		lineList.add(teliphoneLine);
    		
    	}
    	return lineList;
    }
    
    @RequestMapping("/removeLine")
    public @ResponseBody List<TeliphoneLine> removeLine(@RequestBody TeliphoneLine item) {
    	System.out.println();
    	//List<TeliphoneLine> lineList=new ArrayList<TeliphoneLine>();
    	CustomerLine custLine=new CustomerLine();
    	custLine.setCustomerLineID(item.getLineID());
    	CustomerLine customerLine1 =customerLineService.getCustomerLineByLineID(custLine);
    	//TeliphoneLine teliphoneLine=null;
    	Byte deleteStatus=new Byte("0");
    	FacilityNumberPool facilityNumberPool = new FacilityNumberPool();
    	
    		customerLine1.setActive(deleteStatus);
    		try {
				customerLineService.saveCustomerLine(customerLine1);
				facilityNumberPool.setpNumber(""+customerLine1.getLocalLineNumber());
				facilityNumberPool=facilityNumberPoolService.getFacilityNumberPoolsByPhoneNumber(facilityNumberPool);
				facilityNumberPool.setStatus(new Byte("1"));
				facilityNumberPoolService.saveFacilityNumberPool(facilityNumberPool);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		return getCustLineList();
	
}	
    		@RequestMapping("/editLine")
    	    public @ResponseBody List<TeliphoneLine> editLine(@RequestBody TeliphoneLine item) {
    	    	System.out.println();
    	    	CustomerLine custLine=new CustomerLine();
    	    	custLine.setCustomerLineID(item.getLineID());
    	    	CustomerLine customerLine1 =customerLineService.getCustomerLineByLineID(custLine);
    	    	
    	    		customerLine1.setDestinationLineNumber(item.getRoutingNumber());
    	    		try {
    					customerLineService.saveCustomerLine(customerLine1);
    				} catch (IllegalAccessException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (InvocationTargetException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} 
    	
    	    		return getCustLineList();
    	
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
