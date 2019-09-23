package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

//컨트롤러 어노테이션 (컨트롤러를 자동으로 생성)
@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	// 시작 페이지로 이동
	@RequestMapping("/") // url pattern mapping
	public String main(Model model) {
		// Model : 데이터를 담는 그릇 역할, map 구조로 저장됨
		// model.addAttribute("변수명",값)
		model.addAttribute("message", "홈페이지 방문에 환영합니다");
		// <beans:property name="prefix" value = "WEB-INF/views/" />
		// <beans:property name="prefix" value = .jsp />
		// WEB-INF/views/main.jsp

		return "main";
	}

	@RequestMapping(value = "gugu.do", method = RequestMethod.GET)
	public String gugu(@RequestParam int dan, Model model) {
		String result = "";
		for (int i = 1; i <= 9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu";
	}
	
	@RequestMapping("test")
	public void test() {
		
	}
	
	@RequestMapping("test/doA")
	public String doA(Model model) {
		logger.info("doA aclled...");
		model.addAttribute("message", "홈페이지 방문 doA에서 클릭 리턴 doB");
		
		return "test/doB";
		
	}
	
	@RequestMapping("test/doB")
	public void doB() {
		logger.info("doB called....");
	}
	
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		Map<String, Object> map = new HashMap<>();
		map.put("product", new ProductDTO("샤프",1000));
		//new ModelAndView("view의 이름", "맵변수명", "맵");
		return new ModelAndView("test/doC","map",map);
	}
	
	@RequestMapping("test/doD")
	public String doD() {
		//redirect의 경우 return type을 String으로 설정
		//doE.jsp로 리디다이렉트 됨
		return "redirect:/test/doE";
	//	return "redirect:/home.jsp";
	}
	
	@RequestMapping("test/doE")
	public void doE() {
		//doE.jsp로 포워드
	}
	
	
	
	
	

}
