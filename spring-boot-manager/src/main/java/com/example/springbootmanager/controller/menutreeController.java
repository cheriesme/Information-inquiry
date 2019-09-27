package com.example.springbootmanager.controller;

import com.example.springbootmanager.model.UserEntity;
import com.example.springbootmanager.service.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class menutreeController {
    @Autowired
    private UserServiceImpl service;
//    @GetMapping("/main/tree")
//    public String returnList(ModelMap map){
//        List<UserEntity> list = service.findBydeparmentname("研发部");
//        map.addAttribute("umps",list);
//        return "user/list";
//    }
    @GetMapping("/main/tree")
    public List<UserEntity> returnList(){
        List<UserEntity> list = service.findBydeparmentname("研发部");
        return list;
    }
}

