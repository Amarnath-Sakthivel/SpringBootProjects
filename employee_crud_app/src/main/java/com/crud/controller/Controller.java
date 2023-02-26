package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.EmpEntitiy;
import com.crud.service.EmpService;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	@Autowired
	private EmpService empService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView ViewAll() {
		ModelAndView mv = new ModelAndView("emp_list");
		List<EmpEntitiy> list = empService.viewAll();
		mv.addObject("list", list);
		return mv;

	}

	@RequestMapping("/addEmp")
	public String add(Model model, @ModelAttribute("add") EmpEntitiy empEntitiy) {
		return "add_form";

	}

	@GetMapping("/UpdateEmp/{id}")
	public String UpdateEmp(@PathVariable int id, EmpEntitiy empEntitiy) {
//		empEntitiy = empService.getEmpById(id);
//		System.out.println("updated..");
		return "emp_list";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("add") EmpEntitiy empentitiy) {
		ModelAndView mv = new ModelAndView("add_form");
		empService.saveOrupdate(empentitiy);
		mv.addObject("msg", "Inserted successfully");
		return mv;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		empService.delete(id);
		return new ModelAndView("redirect:/");
	}
}
