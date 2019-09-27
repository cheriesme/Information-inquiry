package com.example.springbootmanager.controller;


import com.example.springbootmanager.model.DeparmentEntity;
import com.example.springbootmanager.model.RoleEntity;
import com.example.springbootmanager.model.StaffEntity;
import com.example.springbootmanager.model.UserEntity;
import com.example.springbootmanager.service.userService.UserServiceImpl;
import com.example.springbootmanager.service.deparmentService.deparmentServiceImpl;
import com.example.springbootmanager.service.roleService.roleServiceImpl;
import com.example.springbootmanager.service.staffService.staffServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * controller for user
 * 2019.9.9
 */
@Controller()
public class UserController {
@Autowired
private UserServiceImpl service;
@Autowired
private deparmentServiceImpl depaservice;
@Autowired
private roleServiceImpl roleservice;
@Autowired
private staffServiceImpl stservice;

    /**
     * 显示用户信息
     * @param model
     * @return
     */
    @GetMapping(value = "/main/umps")
    public String list(ModelMap model){
       List<UserEntity> user = service.findAll();
        model.put("umps",user);
        return "user/list";
    }

    /**
     * 显示个人信息for 管理员
     * @param account
     * @param map
     * @return
     */
    @GetMapping("/main/puemp/{account}")
    public  String listPerson(@PathVariable("account")String account,ModelMap map){
      List<UserEntity>  list= service.findByAccount(account);
      map.addAttribute("puemps",list);
      return "/user/listperson";
    }
    /**
     * 新建user
     * @return
     */
    @GetMapping("/main/emp")
     public String addtoPage(ModelMap map){
        List<DeparmentEntity> deparment= depaservice.findAll();
        map.addAttribute("empfD",deparment);
        List<RoleEntity> role = roleservice.findAll();
        map.addAttribute("empfR",role);
        List<StaffEntity> staff = stservice.findAll();
        map.addAttribute("empfs",staff);
        return "/user/add";
}
    @PostMapping("/main/emp")
    public String adtodb(UserEntity userc, ModelMap map){
        UserEntity users = service.findByUserid(userc.getUserid());
   if (users.getUserid()==userc.getUserid()){
       map.addAttribute("msg","该用户ID已存在！");
       return "user/add";
   }
        service.save(userc);
        return "redirect:/main/umps";
}

    /**
     * 编辑
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/main/empe/{id}")
public String toEditpage(@PathVariable("id") Integer id,ModelMap map){
      UserEntity usere = service.findById(id);
        map.addAttribute("empe",usere);
        List<DeparmentEntity> deparment= depaservice.findAll();
        map.addAttribute("empfD",deparment);
        List<RoleEntity> role = roleservice.findAll();
        map.addAttribute("empfR",role);
        List<StaffEntity> staff = stservice.findAll();
        map.addAttribute("empfs",staff);
        return "user/edit";
}
@PutMapping("/main/empe")
public String updata(UserEntity user){
        service.save(user);
        return "redirect:/main/umps";
}
    /**
     * 编辑个人信息(管理员)
     * 2019.9.19 还要添加不可编辑
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/main/editpersoninadmin/{id}")
    public String addpersoninadmin(@PathVariable("id") Integer id,ModelMap map){
        UserEntity usere = service.findById(id);
        map.addAttribute("empe",usere);
        List<DeparmentEntity> deparment= depaservice.findAll();
        map.addAttribute("empfD",deparment);
        List<RoleEntity> role = roleservice.findAll();
        map.addAttribute("empfR",role);
        List<StaffEntity> staff = stservice.findAll();
        map.addAttribute("empfs",staff);
        return "user/personedit";
    }
    @PutMapping("/main/editpersoninadmin")
    public String updatapaersoninadmin(UserEntity user){
        service.save(user);
        return "/user/listperson";
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/main/empd/{id}")
    public  String deleteuser(@PathVariable("id")Integer id){
     service.deleteById(id);
     return "redirect:/main/umps";
    }

    /**
     * 显示登陆用户的信息
     * @param account
     * @param map
     * @return
     */
    @GetMapping("/main/pemp/{account}")
    public String person(@PathVariable("account") String account,ModelMap map){
        List<UserEntity> list = service.findByAccount(account);
        map.addAttribute("pemps",list);
        return "/person/personlist";
     }
    /**
     * 编辑个人信息
     * 2019.9.19 还要添加不可编辑
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/main/epempe/{id}")
    public String addperson(@PathVariable("id") Integer id,ModelMap map){
        UserEntity usere = service.findById(id);
        map.addAttribute("empe",usere);
        List<DeparmentEntity> deparment= depaservice.findAll();
        map.addAttribute("empfD",deparment);
        List<RoleEntity> role = roleservice.findAll();
        map.addAttribute("empfR",role);
        List<StaffEntity> staff = stservice.findAll();
        map.addAttribute("empfs",staff);
        return "person/personedit";
    }
    @PutMapping("/main/epempe")
    public String updatapaerson(UserEntity user){
        service.save(user);
        return "/person/personlist";
    }
    public static String[] toStringArray(List<UserEntity> list){
        String[] arrtlist = new String[list.size()];
        list.toArray(arrtlist);
        return arrtlist;
    }
}

