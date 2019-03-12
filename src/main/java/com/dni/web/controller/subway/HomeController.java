package com.dni.web.controller.subway;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dni.web.entity.Subway;
import com.dni.web.service.SubwayService;
import com.mysql.cj.Session;

@Controller("subwayHomeController")
@RequestMapping("/subway")
public class HomeController {
	
	@Autowired
	private SubwayService subwayService;
	
	 @GetMapping("/")
	 public String index(Model model) {
		 return "subway.index";
	 }
	 
	 @GetMapping("/{id}")
	 public String index(Principal principal, @PathVariable("id") int id, Model model) {
		 //Spring Security 현재 세션 사용자의 정보 
		 String userId = principal.getName();
		 Subway subway = subwayService.getSubway(userId, id);
		 model.addAttribute("subway", subway);
		 
		 return "subway.view";
		 
	 }
}
