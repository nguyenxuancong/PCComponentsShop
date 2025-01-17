package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

}
