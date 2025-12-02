package com.telusko.CRMTh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.CRMTh.model.Customers;
import com.telusko.CRMTh.service.ICustomerService;



@Controller
public class CustomerController 
{
	
	private ICustomerService service;

	@Autowired
	public void setService(ICustomerService service) {
		this.service = service;
	}
	@GetMapping("/cxlist")
	public String getAllCxData(Model model)
	{
		System.out.println("Request in controller");
		List<Customers> customerList = service.getCustomersInfo();
		model.addAttribute("customers", customerList);
		customerList.forEach(c->System.out.println(c));
		return "customerlist";//lvn
	}
	
	@GetMapping("/showform")
	public String showForm(@ModelAttribute("customer")Customers customer)
	{
		
		return "showform";
	}
	
	@GetMapping("/updateform")
	public String updateForm(@ModelAttribute("customer")Customers customer)
	{
		return "showform";
	}
	
	@PostMapping("/registerCustomer")
	public String registerCustomer(@ModelAttribute("customer")Customers customer)
	{
		service.registerCustomer(customer);
		System.out.println("redirect");
		return "redirect:/cxlist";
	}
	
	@GetMapping("/deleteData")
	public String deleteCustomer(@RequestParam Integer id)
	{
		System.out.println("delete");
		
		System.out.println(id);
		service.deleteRecord(id);
	
		return "redirect:/cxlist";
	}
	
//	@PutMapping("/updateCustomer")
//	public String updateCustomer(@ModelAttribute("customer")Customers customer)
//	{
//		service.registerCustomer(customer);
//		System.out.println("redirect");
//		return "redirect:/cxlist";
//	}
	
}
