package edu.mum.cs.cs425.wallymarty.service;

import java.time.LocalDate;
import java.util.List;

import edu.mum.cs.cs425.wallymarty.model.Customer;


public interface ICustomerService {
	public abstract List<Customer> findAllOrderByName();
	public abstract Customer save(Customer supplier);
	public abstract Customer findById(Long id);
	public abstract void delete(Long id);
	List<Customer> findAllByDateOfBirthBeforeOrderByDateOfBirth(LocalDate date);
	
}
