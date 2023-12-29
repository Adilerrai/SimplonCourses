package com.joseph.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseph.entity.Customer;

@Repository("ordreRepository")
public interface OrdreRepository extends JpaRepository<Customer, Integer> {

}