package com.dhacbang.pokeBook.controllers;

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

import com.dhacbang.pokeBook.models.Item;
import com.dhacbang.pokeBook.services.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService serv;
	
	@GetMapping("/")
	public String Index() {
		return "redirect:/dashboard";
	}
	
	//Display______________________________
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("allItems", serv.getAll());
		
		return "dashboard.jsp";
		
	}
	
	@GetMapping("/item/new")
	public String newDog(@ModelAttribute("item") Item item) {
		return "new_item.jsp";
	}
	
	@GetMapping("/items/{id}")
	public String displayDog(@PathVariable("id") Long id, Model model) {
		model.addAttribute("item", serv.getOne(id));
		
		return "display_item.jsp";
	}
	
	@GetMapping("/items/{id}/edit")
	public String editItem(@ModelAttribute("item") Item item, @PathVariable("id") Long id, Model model) {
		model.addAttribute("item", serv.getOne(id));
		return"edit_item.jsp";
	}
	//Action_______________________________
	
	@PostMapping("/item/create")
	public String creatitem(@Valid @ModelAttribute("item")Item item, BindingResult result) {
		if(result.hasErrors()) {
			return "new_item.jsp";
		} else{
			serv.save(item);
			return "redirect:/dashboard";
		}
	}
	
	
	
//	@RequestMapping(value ="", method=RequestMethod.PUT)
	@PutMapping("/items/{id}/update")
	public String updateItem(@Valid @ModelAttribute("item")Item item, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			return "edit_item.jsp";
		} else{
			serv.save(item);
			
			return "redirect:/items/" + id;
		}
	}
	
	@GetMapping("/items/{id}/delete")
	public String deleteItem(@PathVariable("id") Long id) {
		serv.delete(id);
		return "redirect:/dashboard";
	}

}
