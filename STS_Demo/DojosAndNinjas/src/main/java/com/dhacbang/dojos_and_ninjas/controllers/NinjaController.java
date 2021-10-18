package com.dhacbang.dojos_and_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dhacbang.dojos_and_ninjas.models.Ninja;
import com.dhacbang.dojos_and_ninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService serv;
	
	@GetMapping("/")
	public String Index() {
		return "redirect:/dashboard";
	}
	
	//Display______________________________
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("allNinjas", serv.getAll());
		
		return "dashboard.jsp";
		
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja) {
		return "new_ninja.jsp";
	}
	
	@GetMapping("/ninjas/{id}")
	public String displayNinja(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ninja", serv.getOne(id));
		
		return "display_ninja.jsp";
	}
	
	@GetMapping("/ninjas/{id}/edit")
	public String edtNinja(@ModelAttribute("ninja") Ninja ninja, @PathVariable("id") Long id, Model model) {
		model.addAttribute("ninja", serv.getOne(id));
		return"edit_ninja.jsp";
	}
	//Action_______________________________
	
	@PostMapping("/ninja/create")
	public String creatNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "new_ninja.jsp";
		} else{
			serv.save(ninja);
			return "redirect:/dashboard";
		}
	}
	
	
	
//	@RequestMapping(value ="", method=RequestMethod.PUT)
	@PutMapping("/ninjas/{id}/update")
	public String updateNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			return "edit_ninja.jsp";
		} else{
			serv.save(ninja);
			
			return "redirect:/ninjas/" + id;
		}
	}
	
	@GetMapping("/ninjas/{id}/delete")
	public String deleteNinja(@PathVariable("id") Long id) {
		serv.delete(id);
		return "redirect:/dashboard";
	}

}
