package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping("/employee")
    public String getAllEmployees(Model model){
        Collection<Employee> all = employeeDAO.getAll();
        model.addAttribute("all",all);
        return "employee_list";
    }
    @PostMapping("employee")
    public String addEmployee(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/employee/{id}")
    public String update(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDAO.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }
    @PutMapping("employee")
    public String updateEmployee(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }
}
