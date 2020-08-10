package com.luv2code.springdemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
		//get customer from dao
		List<Customer> thcustomers=customerservice.getCustomers();
		//add customer to model
		theModel.addAttribute("customers",thcustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormforAdd(Model theModel)
	{
		// create model attribute to bind form data
				Customer theCustomer = new Customer();
				
				theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer thecustomer)
	
	{
		customerservice.saveCustomer(thecustomer);
	   return "redirect:/customer/list";	
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theid,Model theModel)
	
	{
		//get customer from db using id
		Customer thecustomer=customerservice.getCustomer(theid);
		
		//setup customer in model
		theModel.addAttribute("customer",thecustomer);
		return "customer-form";
		
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theid,Model theModel)
	
	{
		
		customerservice.deleteCustomer(theid);
		
		
		 return "redirect:/customer/list";
		
	}
	
}
