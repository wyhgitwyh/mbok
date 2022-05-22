package com.example.mytoolbk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mytoolbk.entiy.Account;
import com.example.mytoolbk.entiy.Gua;
import com.example.mytoolbk.service.SecurytiUseerDetail;
import com.example.mytoolbk.service.GuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * className:Tool
 * packaae:com.example.mytoolbk.controller
 * Desrciption:
 *
 * @Date:2022/5/11 10:48
 * @Author:86150
 */
@Controller
public class Tool {

    @Autowired
    GuaService toolSaveService;




    @RequestMapping("/test1")
    public  String method(Model map){
        List<String> list =new ArrayList<String>();
        list.add("名字");
        list.add("年龄");
        list.add("财富");


        map.addAttribute("listt",list);
        return  "test1";
    }

    @RequestMapping("/tool/free/dayangsuanfa")
    public  String dayangsuanfa(Model map){
        return  "dayan/zhouyi-daqiugua";
    }

    @RequestMapping("/tool/save/dayangsuanfa")
    public  String dayangsuanfaSave(Model map, Gua gua ) throws  Exception{

        Account user = SecurytiUseerDetail.getUser();
//        System.out.println(ToStringBuilder.reflectionToString("看看："+user));
        gua.setAccountId(user.getId());
        System.out.println("结果如何："+gua);
        toolSaveService.save(gua);
        map.addAttribute("message","保存成功！");
        return  "success";
    }
    @RequestMapping("/tool/save/dayanlist")
    public  String dayangsuanfaList(Model map ) throws  Exception{

        Account user = SecurytiUseerDetail.getUser();
        QueryWrapper<Gua> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account_id",user.getId());
        List<Gua> list = toolSaveService.list(queryWrapper);

        map.addAttribute("guaList",list);
        return  "dayan/list";
    }
    @RequestMapping("/tool/save/dayangsuanfa/delete/{id}")
    public  String delete(Model map,@PathVariable("id") Integer id ) throws  Exception{

        Account user = SecurytiUseerDetail.getUser();
        QueryWrapper<Gua> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account_id",user.getId()).eq("id",id);
        toolSaveService.remove(queryWrapper);
        return  "redirect:/tool/save/dayanlist";
    }




    @RequestMapping("/search")
    public  String search(Model map){
        return  "zhouyi-daqiugua";
    }

    @GetMapping("/tool/free/texttoimg")
    public  String texttoimg(Model map){
        return  "zhouyi-daqiugua";
    }





}
