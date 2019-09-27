package com.example.springbootmanager.controller;

import com.example.springbootmanager.model.UserEntity;
import com.example.springbootmanager.service.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用于搜素
 */
@Controller
public class selectController {
    @Autowired
    private UserServiceImpl dao;
    @RequestMapping("/main/stemp")
    public String outList(UserEntity user, ModelMap map){
        List<UserEntity> list = dao.findByPage(user.getAccount(),user.getPhone());
        map.addAttribute("umps",list);
        if (list.isEmpty()){
            map.addAttribute("msg","对不起，没有找到任何的信息！");
            return "/user/list";
        }
        return "/user/list";
    }


}
