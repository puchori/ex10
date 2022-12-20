package org.zerock.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.aop.LogAdvice;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/*")
@Log4j2
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		
		log.info("do all can access everybody");
	}
	
	@GetMapping("/member")
	public void doMember() {
		
		log.info("logined member");
		
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		
		log.info("admin only");
	}
	
	//어노테이션을 이용한 스프링 시큐리트 설정
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2() {
		log.info("logined annotation member");
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public void doAdmin2() {
		
		log.info("admin annotation only");
	}
	
	

}
