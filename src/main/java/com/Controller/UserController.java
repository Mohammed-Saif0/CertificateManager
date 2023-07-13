package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;
import com.Models.Certificate;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Service.CertificateService;

@Controller
public class UserController {
	@Autowired
	private CertificateService certificateService;
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/getcertificates")
	public String viewCertificate(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		System.out.println("username is = "+username);
		List<Certificate> certificates  = certificateService.getCertificate(username);
		model.addAttribute("certificate",certificates);
		return "viewCertificate";
	}
}
