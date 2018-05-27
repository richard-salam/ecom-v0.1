package com.richie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerClass {
	
	@RequestMapping(value = {"/","home"}, method=RequestMethod.GET)
	private ModelAndView goHome(){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		
		return model;
	}

}
