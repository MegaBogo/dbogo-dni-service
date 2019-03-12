package com.dni.web.controller.subway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dni.web.entity.Subway;
import com.dni.web.service.SubwayService;

@Controller("subwayHomeController")
@RequestMapping("/subway")
public class HomeController {
	
	@Autowired
	private SubwayService subwayService;
	
	 @GetMapping("/")
	 public String index() {
		 return "subway.index";
	 }
	 
	 @GetMapping("/{userId}")
	 public String index(@PathVariable("userId") String userId, Model model) {
		 Subway subway = subwayService.getSubway(userId);
		 model.addAttribute("subway", subway);
		 
		 return "subway.view";
		 
	 }
}
