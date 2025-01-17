package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.base.entity.Addresses;

public interface AddressService {

	List<Addresses> findAll(Example<Addresses> example, Sort sort);

	List<Addresses> findAll(Example<Addresses> example);

	void delete(Addresses entity);

	Addresses getById(Integer id);

	void deleteById(Integer id);

	Addresses getOne(Integer id);

	boolean existsById(Integer id);

	Optional<Addresses> findById(Integer id);

	Page<Addresses> findAll(Example<Addresses> example, Pageable pageable);

	List<Addresses> findAll();

	Optional<Addresses> findOne(Example<Addresses> example);

	Addresses save(Addresses entity);

	long count(Example<Addresses> example);

}
