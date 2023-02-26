package com.thymeleaf.sb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thymeleaf.sb.model.User;

@Controller
@RequestMapping("/thymeleaf")
public class MyController {

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("msg","Welcome to SpringBoot with ThymeLeaf");
		return "index";
	}
	
	@GetMapping("/bspage")
	public String bsPage(Model model) {
		return "bootstrap";
	}
	
	@GetMapping("/dynamic")
	public String dynamicForm(Model model) {
		return "DynamicPage";
	}
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("save");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@GetMapping("/if-unless")
	public ModelAndView ifUnless(User user) {
		ModelAndView mv = new ModelAndView("if-unless");
		List<User> users = new ArrayList<User>();
		int count=0;
		users.add(new User("Amarnath S","amarnath@gmail.com"));
		users.add(new User("Arun A","aarun@gmail.com"));
		users.add(new User("ArunKumar J","jarunkumar@gmail.com"));
		users.add(new User("DhineshKumar R","rdkumarh@gmail.com"));
		mv.addObject("users", users);
		count++;
		mv.addObject("count", count);
		return mv;
		
	}
}
