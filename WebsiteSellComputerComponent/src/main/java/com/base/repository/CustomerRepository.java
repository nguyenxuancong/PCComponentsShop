package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer>{

}
