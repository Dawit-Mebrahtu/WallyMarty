package edu.mum.cs.cs425.wallymarty.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.wallymarty.model.Customer;
import edu.mum.cs.cs425.wallymarty.repository.ICustomerRepository;
import edu.mum.cs.cs425.wallymarty.service.ICustomerService;



@Service("customerService")
public class CustomerService implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public List<Customer> findAllOrderByName() {
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer supplier) {
		return customerRepository.save(supplier);
	}

	@Override
	public Customer findById(Long id) {
		Optional<Customer> os = customerRepository.findById(id);
		return os.orElse(null);
	}

	@Override
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> findAllByDateOfBirthBeforeOrderByDateOfBirth(LocalDate date) {
		return customerRepository.findAllByDateOfBirthBeforeOrderByDateOfBirth(date);
	}

	
}
