package com.vivek.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivek.springdemo.dao.CustomerDAO;
import com.vivek.springdemo.entity.Customer;
import com.vivek.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject customer service 
	@Autowired
	private CustomerService customerService;
	@GetMapping("/list")
	public String listCustomer(Model model) {
		//get customers from customer Service	
		List<Customer> theCustomers = customerService.getCustomers();
		//add the customer to the model
		model.addAttribute("customers",theCustomers);
		return "customers-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		//Create model attributes to bind the data
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		//get customer for customer service
		Customer theCustomer = customerService.getCustomer(theId);
		//set customer to model attribute
		model.addAttribute("customer", theCustomer);
		//send over to customer form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model model ) {
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
		
		//add search result into model attribute 
		model.addAttribute("customers", theCustomers);
		return "customers-list";
	}
}
