package com.dhacbang.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dhacbang.models.Course;
import com.dhacbang.models.User;
import com.dhacbang.services.CourseService;
import com.dhacbang.services.UserService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseServ;
	
	@Autowired
	private UserService userServ;
	
	// ____________________Display_______________________
    
	// Read many
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("allCourse", courseServ.getAll());
		
		
		return "dashboard.jsp";
	}
	
	// _____________________*Create*____________________________
	@GetMapping("/course/new")
	public String newCourseForm(@ModelAttribute("newCourse") Course course, Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		return "new_course.jsp";
	}
	
	// ____________________*Read One*_____________________________
	@GetMapping("/course/{id}")
	public String displayCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("course", courseServ.getOne(id));
		
		
		return "display_course.jsp";
	}
	
	// ____________________*Update*_________________________________
	@GetMapping("/course/{id}/edit")
	public String editCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		Course course = courseServ.getOne(id);
		if (!session.getAttribute("uuid").equals(course.getCreator().getId())) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("course", course);
		
		
		return "edit_course.jsp";
	}
	
	// _________________*Action*_______________________
	

	// __________________Create________________________
	@PostMapping("/course/create")
	public String createCourse(@Valid @ModelAttribute("newCourse") Course course, BindingResult result, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			
			return "new_course.jsp";
		}
		
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		course.setCreator(user);
		
		courseServ.save(course);
		
		return "redirect:/dashboard";
	}
	
	// __________________Update_____________________________
	@PutMapping("/course/{id}/update")
	public String updateCourse(@Valid @ModelAttribute("course") Course courseFromForm, BindingResult result, 
		HttpSession session, @PathVariable("id") Long id, Model model) {
		
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}

		if (result.hasErrors()) {
			model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));

			
			return "edit_course.jsp";
		} else {
			Course courseFromDB = courseServ.getOne(id);
			
			
			if (!session.getAttribute("uuid").equals(courseFromDB.getCreator().getId())) {
				return "redirect:/dashboard";
			}
			
			
			courseFromDB.setName(courseFromForm.getName());
			courseFromDB.setDay(courseFromForm.getDay());
			courseFromDB.setPrice(courseFromForm.getPrice());
			courseFromDB.setDescription(courseFromForm.getDescription());
			
			
			courseServ.save(courseFromDB);
			
			return "redirect:/dashboard";
		}
	}
		
	//________________________Delete____________________________
	
	
	@DeleteMapping("/course/{id}/delete")
	public String deleteCourse(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		Course c = courseServ.getOne(id);
		
		if (!session.getAttribute("uuid").equals(c.getCreator().getId())) {
			return "redirect:/dashboard";
		}
		
		courseServ.delete(id);
		
		return "redirect:/dashboard";
	}
}
