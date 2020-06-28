package com.vivek.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// Need a controller method to show initial HTML Form
	
	@RequestMapping("/showForm")  //  hello/showForm
	public String showForm() {
		return "helloworld-form";
	}
	
	// Need a controller method to process HTML Form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data and 
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		//read request parameter from HTML Data form
		
		String name = request.getParameter("studentName");
		//Convert the Data to all caps
		name = name.toUpperCase();
		//create a message
		String result = "Yo! " + name;
		
		//and message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFromVersionThree")
	public String processFromVersionThree(@RequestParam("studentName") String theName, Model model) {
		//convert to upper case
		theName = theName.toUpperCase();
		
		//create a message
		String result  = "Hey my friend from v3!" + theName;
		//add message to model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	

}
