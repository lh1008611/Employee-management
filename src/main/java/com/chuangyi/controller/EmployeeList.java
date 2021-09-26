package com.chuangyi.controller;

import com.chuangyi.dao.EmployeeDAO;
import com.chuangyi.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeList {
    @Autowired
    EmployeeDAO employeeDAO;

    @RequestMapping("/employeeList")
    public String employeeList(Model model) {
        //controller调service（dao）
        Collection<Employee> employeesList = employeeDAO.getAll();
        model.addAttribute("employeesList", employeesList);
        return "table-basic";
    }
}
