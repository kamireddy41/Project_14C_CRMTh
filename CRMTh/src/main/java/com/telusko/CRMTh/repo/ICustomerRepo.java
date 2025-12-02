package com.telusko.CRMTh.repo;

import org.springframework.data.repository.CrudRepository;

import com.telusko.CRMTh.model.Customers;


public interface ICustomerRepo extends CrudRepository<Customers, Integer> {

}
