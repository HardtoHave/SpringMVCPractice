package org.example.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView include Model and View
         * Model:share data to request scope
         * View: set logic view to implement page jumping
         */
        ModelAndView modelAndView=new ModelAndView();
        //model
        modelAndView.addObject("testRequestScope","hello, model and view");
        //view
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello, session");
        return "success";
    }
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello, application");
        return "success";
    }
}
