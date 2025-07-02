package com.cognizant.orm_learn.handson_4.repository;

import com.cognizant.orm_learn.handson_4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
