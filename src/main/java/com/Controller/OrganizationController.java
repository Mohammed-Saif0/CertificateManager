package com.Controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Models.Organization;
import com.Service.CertificateService;
import com.Service.OrganizationService;
import com.Service.UserService;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class OrganizationController {

	@Autowired
	private OrganizationService orgService;
	@Autowired
	private UserService userService;
	@Autowired
	private CertificateService certificateService;
	@RequestMapping("/orgsignup")
	public String organizationSignup() {
		return "organization/signup";
	}

	@RequestMapping("/orghome")
	public String orgHome() {
		return "organization/home";
	}

	@RequestMapping("/submitOrganizationSignup")
	public String submitOrganizationLogin(@ModelAttribute("organization") Organization org,
			HttpServletRequest request) {
		boolean check = orgService.check(org.getOrganizationName());
		if (check) {
			System.out.println("already exists");
			return "redirect:/organization/signup";
		} else {
			System.out.println("Orgname Doesn't exists");
			orgService.createOrg(org);
			HttpSession session = request.getSession();
			session.setAttribute("username", org.getOrganizationName());
			return "home";
		}
	}

	@RequestMapping("orglogin")
	public String orgLogin() {
		return "organization/login";
	}

	@RequestMapping(path = "/submitOrganizationLogin", method = RequestMethod.POST)
	public String submitOrganizationLogin(@RequestParam("userName") String username,
			@RequestParam("password") String password, HttpServletRequest request) {
		if (orgService.auth(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			return "redirect:/orghome";
		} else {
			return "redirect:/orgsignup";
		}
	}

	@RequestMapping(path = "/certificateUpload", method = RequestMethod.POST)
	public String certificateUpload(@RequestParam("certificate") CommonsMultipartFile file,
			@RequestParam("certificateName") String name, @RequestParam("username") String username,
			HttpSession session) {
		if (userService.check(username) && !certificateService.check(name)) {
			String orgname = (String) session.getAttribute("username");
			String path = session.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
					+ File.separator + "images" + File.separator + orgname + username + name + ".jpg";
			System.out.print(path);
			byte[] data = file.getBytes();
			try {
				FileOutputStream fout = new FileOutputStream(path);
				fout.write(data);
				
				System.out.println("success");
				fout.close();
			} catch (Exception e) {
				// System.: handle exception
				System.out.println("failed");
			}
		}
		
		return "redirect:/orghome";
	}

}
