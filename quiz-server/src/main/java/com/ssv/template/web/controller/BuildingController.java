package com.ssv.template.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssv.template.service.BuildingService;

@Controller
@RequestMapping("/web/building")
public class BuildingController {
	private static final String BASE_DIR = "web/building";

	@RequestMapping(value = { "/index" })
	public String list(Model model) {
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/index";
	}

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("building", new BuildingService().selectBuildingById(id));
		return BASE_DIR + "/details";
	}
}
