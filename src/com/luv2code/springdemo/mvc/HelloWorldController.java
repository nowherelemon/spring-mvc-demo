package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new a controller method to read form data
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request paramenter from the HTML form
		String theName = request.getParameter("studentname");
		//convert the data to all caps
		String result = "Yo!" + theName;
		//create the message
		model.addAttribute("message", result);
		//add message to the model
		return "helloworld";
	}
	

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentname") String theName, 
			Model model) {
		
		//convert the data to all caps
		String result = "Hey My Friend from v3!" + theName;
		//create the message
		model.addAttribute("message", result);
		//add message to the model
		return "helloworld";
	}
}
