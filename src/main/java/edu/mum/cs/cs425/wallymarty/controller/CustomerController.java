package edu.mum.cs.cs425.wallymarty.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.wallymarty.model.Customer;
import edu.mum.cs.cs425.wallymarty.service.ICustomerService;


@Controller
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value="/customers/list", method=RequestMethod.GET)
	public ModelAndView customers() {
		ModelAndView mav = new ModelAndView();
		List<Customer> suppliers = customerService.findAllOrderByName();
		mav.addObject("customers", suppliers);
		mav.setViewName("customer/list");
		return mav;
	}
	
	@RequestMapping(value="/primecustomers/list", method=RequestMethod.GET)
	public ModelAndView primeCustomers() {
		ModelAndView mav = new ModelAndView();
		LocalDate date = LocalDate.now().minusYears(40);
		List<Customer> suppliers = customerService.findAllByDateOfBirthBeforeOrderByDateOfBirth(date);
		mav.addObject("customers", suppliers);
		mav.setViewName("customer/list");
		return mav;
	}
	
	@RequestMapping(value="/customers/new", method = RequestMethod.GET)
	public String customerRegistrationForm(Model model){			
		model.addAttribute("customer", new Customer());
		return "customer/new";
	}
	
	@RequestMapping(value = "/customers/new", method = RequestMethod.POST)
	public String registerNewCustomer(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "customer/new";
		}
		customer = customerService.save(customer);
		return "redirect:/customers/list";
	}
	
	@RequestMapping(value="/customers/edit/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("customer", customerService.findById(id));
		return "customer/new";
	}
	
}
