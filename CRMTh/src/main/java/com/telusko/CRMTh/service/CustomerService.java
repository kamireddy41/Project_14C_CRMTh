package com.telusko.CRMTh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.CRMTh.model.Customers;
import com.telusko.CRMTh.repo.ICustomerRepo;



@Service
public class CustomerService implements ICustomerService
{
    
	private ICustomerRepo repo;
    
    
    @Autowired
	public void setRepo(ICustomerRepo repo) 
	{
		this.repo = repo;
	}

	@Override
	public List<Customers> getCustomersInfo() 
	{
		return (List<Customers>) repo.findAll();
		
	}

	@Override
	public void registerCustomer(Customers customer) 
	{
		repo.save(customer);
		System.out.println("Cx saved");
		
	}

	@Override
	public void deleteRecord(Integer id)
	{
		repo.deleteById(id);
		
	}

}
