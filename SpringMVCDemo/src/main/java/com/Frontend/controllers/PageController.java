package com.Frontend.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.dao.Categorydao;
import com.onlineshop.dao.Userdao;
import com.onlineshop.models.Category;
import com.onlineshop.models.User;


@Controller
public class PageController {
	@Autowired
	HttpSession session;
	
	@Autowired
	Categorydao categoryDao;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getHomePage(){
		
		List<Category> catList=categoryDao.getAllCategories();
		
		Principal principal = request.getUserPrincipal();
		System.out.println("PRINCIPAL IS  NOT ACTIVE " + principal);
		if(principal!=null){
			String userEmail = principal.getName();
			System.out.println("PRINCIPAL IS ACTIVE " + userEmail);
			User user=userdao.getuser(userEmail);
			System.out.println("Object of User = "+user);
			session.setAttribute("userName", user.getName());
			session.setAttribute("userEmail", user.getEmail());
		}
		ModelAndView mv=new ModelAndView("HomePage");
		session.setAttribute("catList",catList);
		return mv;
	}
	@RequestMapping(value="/admin/getProductPage",method=RequestMethod.GET)
		public String getProductOptionPage(){
		
	
			return "ProductOption";
	}
	@RequestMapping(value="/admin/getSupplierPage",method=RequestMethod.GET)
	public String getSupplierOptionPage(){
		return "SupplierOption";
	}
	@RequestMapping(value="/admin/getCategoryPage",method=RequestMethod.GET)
	public String getCategoryOptionPage(){
		return "CategoryOption";
	}
	
	@RequestMapping(value="/getSignUpForm",method=RequestMethod.GET)
	public ModelAndView getSignUp(){
	ModelAndView mv=new ModelAndView("SignUpForm");
	mv.addObject("userObj",new User());
	return mv;
	}
	
	@Autowired
	Userdao userdao;
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userObj")User user){
		
	ModelAndView mv=new ModelAndView("Login");
	user.setRole("USER");
	userdao.registerUser(user);
	return mv;
	}
		@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(name="error",required=false)String error,@RequestParam(name="logout",required=false)String logout) {
	System.out.println("I m in getLogin Form method");
	ModelAndView mv=new ModelAndView("login");
	if(error!=null){
		mv.addObject("msg","Email or password is incorrect");
	}
	if(logout!=null){
		mv.addObject("msg","User has succesfully logged out!!");
	}
	
	return mv;
	} 
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied(){
		
		ModelAndView mv =new ModelAndView("Error");
		mv.addObject("msg", "Sorry!! You are not Authorized to access this page##");
		return mv;
	}
	
	@RequestMapping(value="/doLogout")
	public String loggingOut(HttpServletResponse response) {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:login?logout";
		
	}
	@RequestMapping(value="dologout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		return "redirect:/login?logout";
	}
		
	@RequestMapping(value="/address",method=RequestMethod.GET)
	public ModelAndView address(){
		return null;
	}
	
	
}



