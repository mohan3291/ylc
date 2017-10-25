package com.ylc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/calllog")
public class CallLogController {
    @RequestMapping("/layout")
    public String getCallLogPartialPage() {
        return "calllog/layout";
    }
}
