package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.Models.User;

import com.Service.UserService;

@Controller
public class FirstController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	@RequestMapping(value="/signup")
	public String signUpPage(Model model) {
		return "signup";
	}
	
	@RequestMapping(path="/submitUser",method = RequestMethod.POST)
	public RedirectView submitUser(@ModelAttribute User user, HttpServletRequest request) {
		RedirectView rv = new RedirectView();
		if(this.userService.check(user.getUserName())) {
			rv.setUrl(request.getContextPath()+"/signup");
			rv.addStaticAttribute("error","Username '<b>"+user.getUserName() +"</b>' already exists!!!");
			return rv;
		}
		else {
			userService.createUser(user);
			rv.setUrl(request.getContextPath()+"/");
			return rv;
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(path = "/submitLogin", method=RequestMethod.POST)
	public String submitLogin(@RequestParam("userName") String userName, @RequestParam("password") String password,HttpServletRequest request) {
		if(this.userService.auth(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", userName);
			return "redirect:/home";
		}
		else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "home";
	}
	
	
	
	
}
