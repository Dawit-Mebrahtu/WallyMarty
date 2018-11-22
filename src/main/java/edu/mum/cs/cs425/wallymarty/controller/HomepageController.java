package edu.mum.cs.cs425.wallymarty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomepageController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homepage() {
		return "homepage/index";
	}
	
}
