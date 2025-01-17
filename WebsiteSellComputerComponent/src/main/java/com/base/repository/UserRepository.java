package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	 boolean existsByUsername(String username); // Kiểm tra tồn tại username

	 boolean existsByEmail(String email); // Kiểm tra tồn tại email
}
