package com.dni.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dni.web.entity.study.ChagyebuVO;


@Controller
public class AjaxController {
	/**
	 * GET 방식으로 값을 전달하는 방법 입니다.
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	//@RequestMapping(value = "/searchGet.do", method = RequestMethod.GET)
//	public @ResponseBody Map<String, Object> searchGet(ChagyebuVO vo) throws Exception {
//		LOGGER.info(vo.toString());
//
//		return chagyebuService.selectChagyebuList(vo);
//	}
	
//	@GetMapping("/ajax/search-get")
//	public @ResponseBody String searchGet(ChagyebuVO vo) throws Exception {
//		String[] member = {"한화","삼성"};
//		String[] type = {"1","2","3"};
//		vo.setMember(member);
//		vo.setType(type);
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("member", vo.getMember());
//		map.put("type", vo.getType());
//		
//		//return chagyebuService.selectChagyebuList(vo);
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//	    String json = objectMapper.writeValueAsString(map);
//	    
//	    System.out.println(json);
//	    
//		return json;
//	}
//	
}
