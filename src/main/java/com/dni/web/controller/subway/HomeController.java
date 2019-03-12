package com.dni.web.controller.subway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("subwayHomeController")
@RequestMapping("/subway/")
public class HomeController {
	 @GetMapping("index")
	 public String index() {
		 return "subway.index";
	 }
}
