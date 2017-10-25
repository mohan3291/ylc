package com.ylc.controller;


import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ylc.model.BillingAddress;
import com.ylc.model.Country;
import com.ylc.model.Customer;
import com.ylc.model.FacilityLocation;
import com.ylc.model.InMate;
import com.ylc.model.InmateStatus;
import com.ylc.model.Linetype;
import com.ylc.model.Role;
import com.ylc.model.State;
import com.ylc.model.User;
import com.ylc.service.BillingService;
import com.ylc.service.CountryService;
import com.ylc.service.CustermerService;
import com.ylc.service.FacilityService;
import com.ylc.service.InMateService;
import com.ylc.service.InmateStatusService;
import com.ylc.service.LineTypeService;
import com.ylc.service.StateService;
import com.ylc.service.UserService;



@Controller
public class UserController {

	@Autowired
    private UserService userService;

	@Autowired
    private InMateService inMateService;
	
	@RequestMapping("register")
	public ModelAndView getRegistartion() {	
		return new ModelAndView("guest/register", "message", "");
	}
	
	@RequestMapping("saveUser")
	public ModelAndView saveUser(HttpServletRequest request) {
		String message="User created Successfully";
		User user=new User();
		user.setActive(new Byte("1"));
		user.setPassword(request.getParameter("password"));
		user.setSecurityQuestion("");
		user.setAnswer("");
		user.setEmailID(request.getParameter("email"));			
		Role role=new Role();
		role.setRoleID(1);
		user.setRole(role);		
		Country country=new Country();
		country.setCountryID(1);
		
		State state=new State();
		state.setStateID(1);		
		int status;
		try {
			status=userService.saveUser(user);	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("guest/register", "message", "User already exist...");
		}
		return new ModelAndView("login", "message", message);
	}
	
	@Autowired
    private CountryService countryService;
	
	@Autowired
    private StateService stateService;
	
	@Autowired
    private BillingService billlingService;
	
	@Autowired
    private CustermerService customerService;
	
	@Autowired
    private LineTypeService lineTypeService;
	
	@Autowired
    private InmateStatusService inmateStatusService;
	
	@Autowired
    private FacilityService facilityService;
	
	

}
