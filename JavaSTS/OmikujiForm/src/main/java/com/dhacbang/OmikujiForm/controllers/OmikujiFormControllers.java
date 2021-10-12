package com.dhacbang.OmikujiForm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OmikujiFormControllers {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
}
