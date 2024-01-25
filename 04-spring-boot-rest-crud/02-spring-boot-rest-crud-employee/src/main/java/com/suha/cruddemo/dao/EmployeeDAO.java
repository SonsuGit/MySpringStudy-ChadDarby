package com.suha.cruddemo.dao;

import com.suha.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
