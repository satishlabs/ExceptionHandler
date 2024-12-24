package com.satishlabs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.satishlabs.exception.CityNotFoundException;
import com.satishlabs.exception.CustomerIDNotFoundException;
import com.satishlabs.exception.InvalidPhoneNumberException;
import com.satishlabs.model.Customer;

@Service
public class CustomerService {
	
	public Customer getCustomerByCid(int custId) {
		Customer cust = null;
		if(custId >= 100) {
			cust = new Customer(custId, "Satish", "sat@gmail", 12345, "Ranchi");
		}else {
			throw new CustomerIDNotFoundException();
		}
		return cust;
	}
	
	public Customer getCustomerByPhone(long phone) {
		Customer cust = null;
		if(phone >= 50000) {
			cust = new Customer(109, "Test", "test@gmail", phone, "Blore");
		}else{
			throw new InvalidPhoneNumberException();
		}
		return cust;
	}
	
	public List<Customer> getCustomerByCity(String city){
		List<Customer> custList = new ArrayList<Customer>();
		if(city.equals("Blore")) {
			custList.add(new Customer(101, "Sat", "sat@gmail", 111, city));
			custList.add(new Customer(102, "SPD", "spd@gmail", 222, city));
			custList.add(new Customer(103, "SP", "sp@gmail", 333, "Patna"));
			custList.add(new Customer(104, "PS", "ps@gmail", 444, city));
			custList.add(new Customer(105, "Prasad", "prasad@gmail", 555, city));
			custList.add(new Customer(106, "Prasad", "prasad@gmail", 555, city));
		}else {
			throw new CityNotFoundException();
		}
		return custList;
	}
}
