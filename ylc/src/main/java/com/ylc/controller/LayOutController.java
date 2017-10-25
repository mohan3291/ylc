package com.ylc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LayOutController {
	
	@RequestMapping("pay")
	public String gePayPage() {	
		return "pay";
	}
	@RequestMapping("dashboard")
	public String getdashboardPage() {	
		return "dashboard";
	}
	@RequestMapping("account")
	public String getAccountPage() {	
		return "account";
	}
}
