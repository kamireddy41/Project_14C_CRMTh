package com.telusko.CRMTh.service;

import java.util.List;

import com.telusko.CRMTh.model.Customers;



public interface ICustomerService 
{
	public List<Customers> getCustomersInfo();
	public void registerCustomer(Customers customer);
	public void deleteRecord(Integer id);

}
