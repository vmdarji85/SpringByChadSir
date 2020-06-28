package com.vivek.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showform")
	public String showForm(Model model) {
		//create student object
		Student theStudent = new Student();
		// add student object to model
		model.addAttribute("student", theStudent);
		
		model.addAttribute("theCountryOptions",countryOptions );
		
		return "student-form";
	}
	
	@RequestMapping("/processform")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("Student: " + theStudent.getFirstName() + " " + theStudent.getLastName() );
		return "student-confirmation";
	}

}
