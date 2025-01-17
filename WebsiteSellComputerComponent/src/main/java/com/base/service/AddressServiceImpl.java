package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.base.entity.Addresses;
import com.base.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Addresses save(Addresses entity) {
		return addressRepository.save(entity);
	}

	@Override
	public Optional<Addresses> findOne(Example<Addresses> example) {
		return addressRepository.findOne(example);
	}

	@Override
	public List<Addresses> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Page<Addresses> findAll(Example<Addresses> example, Pageable pageable) {
		return addressRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Addresses> findById(Integer id) {
		return addressRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return addressRepository.existsById(id);
	}

	@Override
	public long count(Example<Addresses> example) {
		return addressRepository.count(example);
	}

	@Override
	public Addresses getOne(Integer id) {
		return addressRepository.getOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		addressRepository.deleteById(id);
	}

	@Override
	public Addresses getById(Integer id) {
		return addressRepository.getById(id);
	}

	@Override
	public void delete(Addresses entity) {
		addressRepository.delete(entity);
	}

	@Override
	public List<Addresses> findAll(Example<Addresses> example) {
		return addressRepository.findAll(example);
	}

	@Override
	public List<Addresses> findAll(Example<Addresses> example, Sort sort) {
		return addressRepository.findAll(example, sort);
	}
	
	
}
