package com.ylc.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylc.model.CustomerLine;
import com.ylc.model.TeliphoneLine;
import com.ylc.model.User;
import com.ylc.model.Customer;
import com.ylc.model.DashBoard;
import com.ylc.model.InMate;
import com.ylc.service.CountryService;
import com.ylc.service.CustermerService;
import com.ylc.service.CustomerLineService;
import com.ylc.service.InMateService;
import com.ylc.service.UserService;
import com.ylc.util.YlcConstents;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	/*@Autowired
    private CustermerService customerService;*/
	
	@Autowired
    private CountryService countryService;
	
	@Autowired
    private CustermerService customerService;
	
	@Autowired
    private UserService userService;
	@Autowired
	private InMateService inMateService;
	@Autowired
	private CustomerLineService customerLineService;
	
    @RequestMapping("/dashboardInfo.json")
    public @ResponseBody List <InMate> getInMateList() {
    /*	Customer customer=new Customer();
		customer.setCustomerID(1);
		customer=customerService.getCustomerById(customer);
			List <Customer> inamtes=new ArrayList();
			inamtes.add(customer);
    	inamtes.add(customer);
		//return customer;
*/    	List <InMate> inamtes=new ArrayList<InMate>();
    	InMate inmate1=new InMate();
    	inmate1.setInmateFirstName("Raghu");
    	inmate1.setInmateLastName("Ravula");
    	InMate inmate2=new InMate();
    	inmate2.setInmateFirstName("Bindu");
    	inmate2.setInmateLastName("Ravula");
    	inamtes.add(inmate1);
    	inamtes.add(inmate2);
    	/*inamtes.add(customer);
    	inamtes.add(customer);*/
        return inamtes;
    }
    
    
    @RequestMapping("/logout")
    public @ResponseBody String logout(HttpServletRequest  request) {
    	  HttpSession session = request.getSession(false);
    	    session.invalidate();
    	    return "login";
    }
    
    
    
    @RequestMapping("/customerInfo.json")
    public @ResponseBody DashBoard getCustomer(HttpServletRequest  request) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
    	String userID=SecurityContextHolder.getContext().getAuthentication().getName();
    	DashBoard dashBoard=new DashBoard();
    	Set<String> inmateSet=new HashSet<String>();
	    	if(userID!=null && !YlcConstents.ANONYMOUSUser.equalsIgnoreCase(userID)){
	    	User user=new User();
	    	user.setCustomerID(Integer.parseInt(userID));
	    	user=userService.findByUserById(user);
	    	request.getSession().setAttribute("userID", user.getCustomerID());
	    	Customer customer=user.getCustomer();    	
	    	
	        request.getSession().setAttribute("customerID",user.getCustomerID() );
	    	if(customer!=null){    	  
	    	   dashBoard.setAccountname(customer.getFirstName());
	    	}
	    	if(user.getCreatedDate()!=null)
	       	   dashBoard.setStartDate(user.getCreatedDate().toString());    		
	    	   dashBoard.setLogin(user.getEmailID());
	    	   dashBoard.setLoginId(user.getEmailID());
	    	   BigDecimal inMateBalance=new BigDecimal(0);
	    	   int noofLines=0;
	    	   for( CustomerLine customerLine:user.getCustomerLines()){
	    		   System.err.println("customerLine.getInMate().getPrePaidAmount()>>>>"+customerLine.getInMate().getPrePaidAmount());
	    		if(customerLine.getActive()==1 && customerLine.getInMate()!=null && customerLine.getInMate().getPrePaidAmount()!=null && !inmateSet.contains(customerLine.getInMate().getBopNumber())){
	    			inmateSet.add(customerLine.getInMate().getBopNumber());
	    			inMateBalance=inMateBalance.add(customerLine.getInMate().getPrePaidAmount());
	    		}
	    		if(customerLine.getActive()==1)
	    			noofLines++;
	   		   }
	    		
	    		if(user.getActive()==1){
	    			dashBoard.setStatus("Active");
	    		}else{
	    			dashBoard.setStatus("In Active");
	    		}
	    		dashBoard.setAccountBal("$"+customer.getPrePaidAmount());    		
	    		dashBoard.setActiveLines(""+noofLines);
	    		
	    	}
            return dashBoard;
        }
   
    @RequestMapping("/inmateSearch")
    public String getCarPartialPage() {
        System.out.println("Suresh");
    	return "pay/inmateSearch";
        
    }
    @RequestMapping("/dashboard")
    public String getdashboardPage() {
        System.out.println("Suresh");
    	return "pay/inmateSearch";
        
    }
    @RequestMapping("/layout")
    public String getdashboardLayoutPage(HttpServletRequest  request) {
        HttpSession session=request.getSession();
        System.out.println(session.getAttribute("userName"));
    	System.out.println("Suresh");
    	return "dashboard/layout";
        
    }
	
}
