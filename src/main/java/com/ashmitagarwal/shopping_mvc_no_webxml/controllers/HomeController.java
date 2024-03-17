package com.ashmitagarwal.shopping_mvc_no_webxml.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@ResponseBody
	@RequestMapping("test")
	public String test()
	{
		return "Hello World";
	}
	
	@RequestMapping("homepage")
	public String homepage()
	{
		return "HomePage";
	}
	
	@RequestMapping("userLogin")
	public String userLogin()
	{
		return "UserLoginPage";
	}
	
	@RequestMapping("userRegistration")
	public String userRegistration()
	{
		return "UserRegistrationPage";
	}
	
	@ResponseBody
	@PostMapping("userLogin")
	public String userLogin(@RequestParam Map<String, String> params)
	{
		String username = params.get("username");
		String password = params.get("password");
		
		if(!username.isBlank() && !password.isBlank())
		{
			if(username.equals("ashmit") && password.equals("password"))
				return "You are logged in!";
		}
		return "Invalid input, try again!";
	}
	
	@ResponseBody
	@PostMapping("userRegistration")
	public String userRegistration(@RequestParam Map<String, String> params)
	{
		String fname = params.get("fname");
		String mname = params.get("mname");
		String lname = params.get("lname");
		String username = params.get("username");
		String email = params.get("email");
		String password = params.get("password");
		
		System.out.println("fname : " + fname );
		System.out.println("mname : " + mname );
		System.out.println("lname : " + lname );
		System.out.println("username : " + username );
		System.out.println("email : " + email );
		System.out.println("password : " + password );
		
		if(fname.isBlank() || username.isBlank() || email.isBlank() || password.isBlank())
			return "Invalid input, try again!";
		return "Congratulations! You are registered!";
	}
}
