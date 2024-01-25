package com.suha.cruddemo.rest;

import com.suha.cruddemo.dao.EmployeeDAO;
import com.suha.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeDAO employeeDAO;
    // quick and dirty: inject employee dao
    public EmployeeRESTController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    // expose /employee and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findALl(){
        return employeeDAO.findAll();
    }

}
