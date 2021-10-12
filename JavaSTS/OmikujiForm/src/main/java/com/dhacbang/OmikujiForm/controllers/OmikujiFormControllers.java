package com.dhacbang.OmikujiForm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiFormControllers {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/submit")
	public String enterCode(
			HttpSession session,
			@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="living_thing") String living_thing,
			@RequestParam(value="compliment") String compliment) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living_thing", living_thing);
		session.setAttribute("compliment", compliment);
		return "redirect:/display";
	}
	@GetMapping("/display")
	public String displayInfo() {
		return "display.jsp";
	}
	
}
