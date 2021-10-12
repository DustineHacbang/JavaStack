package com.dhacbang.session.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SessionControllers {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String enterCode(@RequestParam(value="code")String code, HttpSession session, RedirectAttributes rA) {
		if(!code.equals("groot")) {
			rA.addFlashAttribute("error", "That is the wrong code! No ENTRY! :D");
			
			return "redirect:/";
			
		}
		session.setAttribute("code", code);
		
		return "redirect:/home";
		
	}
	@GetMapping("/home")
	public String home(HttpSession session,Model model) {
		model.addAttribute("code", session.getAttribute("code"));
		return"code.jsp";
	}
	
}
