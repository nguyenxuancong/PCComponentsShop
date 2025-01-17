package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.base.entity.Users;

public interface UserService {

	void deleteAll();

	List<Users> findAll(Example<Users> example, Sort sort);

	void deleteById(Integer id);

	Users getOne(Integer id);

	boolean existsById(Integer id);

	Optional<Users> findById(Integer id);

	Page<Users> findAll(Example<Users> example, Pageable pageable);

	List<Users> findAllById(Iterable<Integer> ids);

	List<Users> findAll();

	Optional<Users> findOne(Example<Users> example);

	Users save(Users entity);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
