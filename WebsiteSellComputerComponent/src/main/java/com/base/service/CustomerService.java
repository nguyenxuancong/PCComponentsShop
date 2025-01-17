package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.base.entity.Customers;

public interface CustomerService {

	List<Customers> findAll(Example<Customers> example, Sort sort);

	List<Customers> findAll(Example<Customers> example);

	void delete(Customers entity);

	Customers getById(Integer id);

	void deleteById(Integer id);

	long count();

	Customers getOne(Integer id);

	boolean existsById(Integer id);

	Optional<Customers> findById(Integer id);

	Page<Customers> findAll(Example<Customers> example, Pageable pageable);

	List<Customers> findAll();

	Optional<Customers> findOne(Example<Customers> example);

	Customers save(Customers entity);

	boolean exists(Example<Customers> example);

}
