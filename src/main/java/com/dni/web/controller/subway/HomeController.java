package com.dni.web.controller.subway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dni.web.service.SubwayService;

@Controller("subwayHomeController")
@RequestMapping("/subway/")
public class HomeController {
	
	@Autowired
	private SubwayService subwayService;
	
	 @GetMapping("index")
	 public String index() {
		 
		 return "subway.index";
	 }
}
