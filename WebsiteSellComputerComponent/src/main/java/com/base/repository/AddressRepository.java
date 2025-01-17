package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.entity.Addresses;

@Repository
public interface AddressRepository extends JpaRepository<Addresses, Integer>{

}
