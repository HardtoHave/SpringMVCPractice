package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestParamController {
    /*
    * get parameter by servlet api
    * in param position put HttpServletRequest(jakarta)
    * using request object to get parameters
    * */
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username"+username+",password"+password);
        return "success";
    }
    /*
    * get parameter by Spring MVC framework
    * put exactly same parameter names in parameter position
    * if names are different, instead using @RequestParam("front-end name") String back-end name
    * */
    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "username") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jSessionId
    ){
        System.out.println("username:"+username+",password:"+password+", referer:"+referer+",jSessionId:"+jSessionId);
        return "success";
    }
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}
