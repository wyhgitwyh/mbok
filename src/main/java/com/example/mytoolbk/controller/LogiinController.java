package com.example.mytoolbk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * className:LogiinController
 * packaae:com.example.mytoolbk.controller
 * Desrciption:
 *
 * @Date:2022/5/11 22:41
 * @Author:86150
 */
@Controller
public class LogiinController {


    @GetMapping("/login")
    public  String login(){
        return "login";
    }
//
//    @PostMapping("/login")
//    public  String postlogin(String account, String password, Boolean remenberMe, HttpServletResponse response){
//
//
//
//
//        System.out.println(account);
//        System.out.println(password);
//        System.out.println(remenberMe);
//
//        return "redirect:index";
//    }

}
