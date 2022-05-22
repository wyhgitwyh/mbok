package com.example.mytoolbk.aop.controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 所有controller的异常都在这捕获
 * 
 * @author 86150
 *
 */
@Slf4j
@ControllerAdvice(basePackages = "com.example.mytoolbk.controller")
public class AllControllerException   {


	
	
	
	
	@ExceptionHandler(Exception.class)
//	@ResponseBody
	public String otherError(Exception e, Model model) {
		System.out.println("未知异常类型："+e.getClass().toString());
		System.out.println(e.getLocalizedMessage());
		model.addAttribute("message",e.getMessage());
		return  "error";
	}

	
}
