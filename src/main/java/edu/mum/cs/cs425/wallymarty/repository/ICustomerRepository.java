package edu.mum.cs.cs425.wallymarty.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.wallymarty.model.Customer;


@Repository("supplierRepository")
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findAllByDateOfBirthBeforeOrderByDateOfBirth(LocalDate date);

}

