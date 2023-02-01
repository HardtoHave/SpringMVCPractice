package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping("/employee")
    public String getAllEmployees(Model model){
        Collection<Employee> all = employeeDAO.getAll();
        model.addAttribute("all",all);
        return "employee_list ";
    }
}
