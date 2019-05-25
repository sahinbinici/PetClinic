package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.PetClinicService;

@Controller
public class PetClinicController {

	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(value="/login.html")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/owners",method=RequestMethod.GET)
	public ModelAndView getOwners() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("owners", petClinicService.findOwners());
		return mav;
	}
	
	@RequestMapping("/pets")
	@ResponseBody
	public String welcome() {
		return "welcome page";
	}
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
