package com.darek.employee.CRUD_employee.controller;

import com.darek.employee.CRUD_employee.entity.Employee;
import com.darek.employee.CRUD_employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class AppController {

    private EmployeeService employeeService;

    @Autowired
    public AppController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model themodel) {
        List<Employee> employees = employeeService.findAll();

        themodel.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/start")
    public String startPage(Model model) {

        model.addAttribute("theDate", new java.util.Date());

        return "startPage";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        //redirect to prevent duplication submissions (powielanie zgłoszeń)
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }
    }
