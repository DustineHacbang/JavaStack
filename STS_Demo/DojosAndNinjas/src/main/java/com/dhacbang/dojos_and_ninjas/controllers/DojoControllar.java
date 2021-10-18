package com.dhacbang.dojos_and_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dhacbang.dojos_and_ninjas.models.Dojo;
import com.dhacbang.dojos_and_ninjas.services.DojoService;
import com.dhacbang.dojos_and_ninjas.services.NinjaService;

@Controller
public class DojoControllar {
	@Autowired
	private DojoService dojoServ;
	
	@Autowired
	private NinjaService ninjaServ;
	
	//Display______________________________
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo, Model model) {
		model.addAttribute("allNinjas", ninjaServ.getAll());
		return "new_dojo.jsp";
	}
	
	
	//Action_______________________________
	
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allNinjas", ninjaServ.getAll());
			return "new_dojo.jsp";
		}else {
			dojoServ.save(dojo);
			return"redirect:/dashboard";
		}
	}
	
}
