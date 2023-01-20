package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    //request url is /test/hello
    @RequestMapping({"/hello","/abc"})
    public String hello(){
        return "success";
    }
}
