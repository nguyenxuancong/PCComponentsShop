package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.base.entity.Employees;

public interface EmployeeService {

	List<Employees> findAll(Example<Employees> example, Sort sort);

	Employees getReferenceById(Integer id);

	void delete(Employees entity);

	Employees getById(Integer id);

	void deleteById(Integer id);

	Employees getOne(Integer id);

	long count(Example<Employees> example);

	boolean existsById(Integer id);

	Optional<Employees> findById(Integer id);

	Page<Employees> findAll(Example<Employees> example, Pageable pageable);

	List<Employees> findAll();

	Optional<Employees> findOne(Example<Employees> example);

	Employees save(Employees entity);

}
