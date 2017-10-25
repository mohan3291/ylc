package com.ylc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylc.service.CustermerService;
import com.ylc.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/numbermgmt")
public class NumberMgmtController {
	@Autowired
    private UserService userService;
	
	@Autowired
    private CustermerService customerService;
    @RequestMapping("/layout")
    public String getnumbermgmtPage() {
        return "numbermgmt/layout";
    }
}
