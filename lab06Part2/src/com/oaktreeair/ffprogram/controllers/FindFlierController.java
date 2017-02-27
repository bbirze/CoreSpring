package com.oaktreeair.ffprogram.controllers;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oaktreeair.ffprogram.ContactInfo;
import com.oaktreeair.ffprogram.Flier;

// controller will respond to a URL that ends in "/findFlier.html".
//
@Controller
@RequestMapping("/findFlier")
public class FindFlierController {

	@Autowired 
	private ApplicationContext applicationContext;
	
	@RequestMapping(method=RequestMethod.GET)
	public void setupForm(Model model) {
		model.addAttribute("flierId", "flier01");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@RequestParam("flierId") String flierId, Model model) {
		
		try {
			Flier flier = (Flier)applicationContext.getBean(flierId);
			
			model.addAttribute("msg", "Flier found successfully!");
			model.addAttribute("flierName", flier.getFlierName());
			ContactInfo inf = flier.getContactInfo();
			model.addAttribute("flierEmail", inf.getEmailAddress());
			
		} catch(NoSuchBeanDefinitionException e)  {
			model.addAttribute("msg", "Flier " + flierId + " not found!");
		}
		
		return "showFlier";
	}

}
