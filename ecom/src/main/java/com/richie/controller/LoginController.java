package com.richie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.richie.entity.LoginEntity;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView init(ModelAndView model) {

		model.addObject("msg", "Please Enter Your Login Details");
		model.setViewName("login");
		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(ModelAndView model, @ModelAttribute("loginEntity") LoginEntity loginEntity) {

		if (loginEntity != null && loginEntity.getUserName() != null && loginEntity.getPassword() != null) {

			if (loginEntity.getUserName().equals("richie") && loginEntity.getPassword().equals("richie123")) {

				return new ModelAndView("redirect:/");
				
			} else {

				model.addObject("error", "Invalid Details");
				model.setViewName("login");
				return model;
			}
		} else {

			model.addObject("error", "Please Enter Details");
			model.setViewName("login");
			return model;
		}
	}

}
