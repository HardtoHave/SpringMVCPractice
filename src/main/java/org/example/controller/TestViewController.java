package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){
        return "success";
    }
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        return "forward:/test/mav";
    }
    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        return "redirect:/test/mav";
    }
}