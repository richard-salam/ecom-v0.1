package com.richie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.richie.entity.EntityClass;
import com.richie.service.EntityService;

@Controller
public class ControllerClass {

	@Autowired
	private EntityService entityService;

	@RequestMapping(value = {"/","home" }, method = RequestMethod.GET)
	public ModelAndView goHome() throws IOException {

		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		List<EntityClass> list = entityService.listUser();
		model.addObject("list", list);

		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUser() {

		ModelAndView model = new ModelAndView();
		model.setViewName("form");
		EntityClass user = new EntityClass();
		model.addObject("user", user);

		return model;
	}

	/*
	 * @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	 * public ModelAndView updateUser(@PathVariable("id") int id) {
	 * 
	 * ModelAndView model = new ModelAndView(); model.setViewName("form");
	 * EntityClass user = entityService.getUserById(id); model.addObject("user",
	 * user);
	 * 
	 * return model; }
	 */

	@RequestMapping(value = "**/save", method = RequestMethod.POST )
	public ModelAndView saveUser(@ModelAttribute("user") EntityClass user) {

		if (user.getId() == 0) {

			entityService.saveUser(user);

		} else {

			entityService.UpdateUser(user);

		}

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));
		entityService.deleteUser(id);

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView editUser(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));
		EntityClass user = entityService.getUserById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("form");
		model.addObject("user", user);

		return model;
	}

}
