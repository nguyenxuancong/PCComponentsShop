package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.base.entity.Customers;
import com.base.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customers save(Customers entity) {
		return customerRepository.save(entity);
	}

	@Override
	public Optional<Customers> findOne(Example<Customers> example) {
		return customerRepository.findOne(example);
	}

	@Override
	public List<Customers> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Page<Customers> findAll(Example<Customers> example, Pageable pageable) {
		return customerRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Customers> findById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return customerRepository.existsById(id);
	}

	@Override
	public boolean exists(Example<Customers> example) {
		return customerRepository.exists(example);
	}

	@Override
	public Customers getOne(Integer id) {
		return customerRepository.getOne(id);
	}

	@Override
	public long count() {
		return customerRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customers getById(Integer id) {
		return customerRepository.getById(id);
	}

	@Override
	public void delete(Customers entity) {
		customerRepository.delete(entity);
	}

	@Override
	public List<Customers> findAll(Example<Customers> example) {
		return customerRepository.findAll(example);
	}

	@Override
	public List<Customers> findAll(Example<Customers> example, Sort sort) {
		return customerRepository.findAll(example, sort);
	}
	
	
}
