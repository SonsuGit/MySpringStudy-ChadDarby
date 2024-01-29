package com.suha.cruddemo.dao;

import com.suha.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that;s it... wow!
}
