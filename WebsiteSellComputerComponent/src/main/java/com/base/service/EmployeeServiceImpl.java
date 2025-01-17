package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.base.entity.Employees;
import com.base.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employees save(Employees entity) {
		return employeeRepository.save(entity);
	}

	@Override
	public Optional<Employees> findOne(Example<Employees> example) {
		return employeeRepository.findOne(example);
	}

	@Override
	public List<Employees> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Page<Employees> findAll(Example<Employees> example, Pageable pageable) {
		return employeeRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Employees> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return employeeRepository.existsById(id);
	}

	@Override
	public long count(Example<Employees> example) {
		return employeeRepository.count(example);
	}

	@Override
	public Employees getOne(Integer id) {
		return employeeRepository.getOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employees getById(Integer id) {
		return employeeRepository.getById(id);
	}

	@Override
	public void delete(Employees entity) {
		employeeRepository.delete(entity);
	}

	@Override
	public Employees getReferenceById(Integer id) {
		return employeeRepository.getReferenceById(id);
	}

	@Override
	public List<Employees> findAll(Example<Employees> example, Sort sort) {
		return employeeRepository.findAll(example, sort);
	}
	
	
}
