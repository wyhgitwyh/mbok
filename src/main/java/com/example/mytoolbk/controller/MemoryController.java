package com.example.mytoolbk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mytoolbk.entiy.BasicMemory;
import com.example.mytoolbk.service.BasicMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * className:MemoryController
 * packaae:com.example.mytoolbk.controller
 * Desrciption:记忆类的
 *
 * @Date:2022/5/18 8:43
 * @Author:86150
 */
@Controller
public class MemoryController {


    @Autowired
    BasicMemoryService basicMemoryService;


    @RequestMapping("/tool/free/jiyibianma")
    public  String dayangsuanfa(Model map,String search){

        if(search==null)
            search="";
        List<BasicMemory> list =null;
        QueryWrapper<BasicMemory> q=new QueryWrapper<>();
//        q.orderByAsc("symbol");

        switch (search){
            case "num":
            case "letter":
                q.like("lable",search);
                list=basicMemoryService.list();
                break;
            default:
                list= basicMemoryService.list(q);
                break;
        }


        map.addAttribute("list",list);
        return  "jiyi/basicmemory";
    }
    @RequestMapping("/tool/save/jiyibianma/show")
    public  String jisyitype(Model map,String type){


        basicMemoryService.list();
        return  "jiyi/basicmemory";
    }





}
