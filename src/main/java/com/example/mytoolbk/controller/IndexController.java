package com.example.mytoolbk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:IndexController
 * packaae:com.example.mytoolbk.controller
 * Desrciption:
 *
 * @Date:2022/5/13 10:17
 * @Author:86150
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public  String index(){
        return  "index";
    }


}
