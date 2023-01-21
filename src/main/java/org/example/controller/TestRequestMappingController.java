package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    //request url is /test/hello
    /*
    params 4 kinds expression:
    "param": current request parameters must have "param"
    "!param":current request parameters must don't have "!param"
    "param=value":current request parameters must have "param" and value must be "value"
    "param!=value"current request parameters can exclude "param", but if hava "param", the value can't be "value"

    * */
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.GET,RequestMethod.POST}
            //params = {"username","!password","age=20","gender!=male"}
    )
    public String hello(){
        return "success";
    }
    /*
        ant style:
        ?: represent any single character(exclude ?)
        *: represent any multiple characters(exclude ? and /)
        **: represent any directories, can only be used as "slash(/)**slash(/)"
    */
    @RequestMapping("/a*a/abc/ant")
    public String testAnt(){
        return "success";
    }
    @RequestMapping("/test/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        return "success";
    }
}
