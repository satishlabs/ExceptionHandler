package com.satishlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.satishlabs.exception.CityNotFoundException;
import com.satishlabs.exception.CustomerIDNotFoundException;
import com.satishlabs.exception.InvalidPhoneNumberException;
import com.satishlabs.model.Customer;
import com.satishlabs.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/mycustomer/custid/{custid}")
	public Customer getCustomerByCid(@PathVariable("custid")int custid) {
		System.out.println("CC- getCustomerByCid() - "+custid);
		Customer cust = null;
		try {
			cust = customerService.getCustomerByCid(custid);
		}catch (CustomerIDNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID Not Found", e);
		}
		return cust;
	}
	
	@GetMapping("/mycustomer/phone/{phone}")
	public Customer getCustomerByPhone(@PathVariable("phone")long phone) {
		System.out.println("CC- getCustomerByPhone() - "+phone);
		Customer cust = null;
		try {
			cust = customerService.getCustomerByPhone(phone);
		}catch (InvalidPhoneNumberException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone Number Not Found!!", ex);
		}
		return cust;
	}
	
	@GetMapping("/mycustomer/city/{city}")
	public List<Customer> getCustomerByCity(@PathVariable("city")String city){
		System.out.println("CC- getCustomerByCity() - "+city);
		List<Customer> custList = null;
		try {
			custList = customerService.getCustomerByCity(city);
		}catch (CityNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "City Not Found!!",ex);
		}
		return custList;
	}
}
