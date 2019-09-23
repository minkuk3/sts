package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject	//MemberService 객체가 주입됨
	MemberService memberService;

	@RequestMapping("member/list.do")	//사용자가 요청하는 주소
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		logger.info("회원목록:" + list);
		model.addAttribute("list", list);	//모델에 저장
		return "member/member_list";	//출력 페이지로 포워딩
	}

}
