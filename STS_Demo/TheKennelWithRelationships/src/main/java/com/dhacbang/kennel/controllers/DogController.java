package com.dhacbang.kennel.controllers;

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

import com.dhacbang.kennel.models.Dog;
import com.dhacbang.kennel.services.DogService;

@Controller
public class DogController {
	
	@Autowired
	private DogService serv;
	
//	@GetMapping("/")
//	public String Index() {
//		return "redirect:/dashboard";
//	}
	
	//Display______________________________
	
//	@GetMapping("/dashboard")
//	public String dashboard(Model model) {
//		model.addAttribute("allDogs", serv.getAll());
//		
//		return "dashboard.jsp";
//		
//	}
	
	@GetMapping("/dog/new")
	public String newDog(@ModelAttribute("dog") Dog dog) {
		return "new_dog.jsp";
	}
	
	@GetMapping("/dogs/{id}")
	public String displayDog(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dog", serv.getOne(id));
		
		return "display_dog.jsp";
	}
	
	@GetMapping("/dogs/{id}/edit")
	public String edtDog(@ModelAttribute("dog") Dog dog, @PathVariable("id") Long id, Model model) {
		model.addAttribute("dog", serv.getOne(id));
		return"edit_dog.jsp";
	}
	//Action_______________________________
	
	@PostMapping("/dog/create")
	public String creatDog(@Valid @ModelAttribute("dog")Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			return "new_dog.jsp";
		} else{
			serv.save(dog);
			return "redirect:/dashboard";
		}
	}
	
	
	
//	@RequestMapping(value ="", method=RequestMethod.PUT)
	@PutMapping("/dogs/{id}/update")
	public String updateDog(@Valid @ModelAttribute("dog")Dog dog, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			return "edit_dog.jsp";
		} else{
			serv.save(dog);
			
			return "redirect:/dogs/" + id;
		}
	}
	
	@GetMapping("/dogs/{id}/delete")
	public String deleteDog(@PathVariable("id") Long id) {
		serv.delete(id);
		return "redirect:/dashboard";
	}

}
