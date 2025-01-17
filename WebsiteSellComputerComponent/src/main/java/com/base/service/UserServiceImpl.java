package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.base.entity.Users;
import com.base.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users save(Users entity) {
		return userRepository.save(entity);
	}

	@Override
	public Optional<Users> findOne(Example<Users> example) {
		return userRepository.findOne(example);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<Users> findAllById(Iterable<Integer> ids) {
		return userRepository.findAllById(ids);
	}

	@Override
	public Page<Users> findAll(Example<Users> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Users> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return userRepository.existsById(id);
	}

	@Override
	public Users getOne(Integer id) {
		return userRepository.getOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<Users> findAll(Example<Users> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	
	
}
