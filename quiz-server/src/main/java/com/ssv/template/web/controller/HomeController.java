package com.ssv.template.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssv.template.service.BuildingService;

@Controller
@RequestMapping("/web/home")
public class HomeController {
	private static final String BASE_DIR = "web/home";

	@RequestMapping(value = { "/index" })
	public String list(Model model) {
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/index";
	}
}
