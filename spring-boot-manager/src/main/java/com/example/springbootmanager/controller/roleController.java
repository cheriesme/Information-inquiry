package com.example.springbootmanager.controller;

import com.example.springbootmanager.model.RoleEntity;
import com.example.springbootmanager.service.roleService.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * role控制器
 */
@Controller
public class roleController {
    @Autowired
    private roleService service;
    @GetMapping("/main/remps")
    public String list(ModelMap map){
        List<RoleEntity > list = service.findAll();
        map.put("remps",list);
        return "/role/list";
    }

    /**
     * 添加
     * @return
     */
    @GetMapping("/main/remp")
    public String addtoPage(){
        return "/role/add";
    }
    @PostMapping("/main/remp")
    public String addtodb(RoleEntity roleEntity){
        service.save(roleEntity);
        return "redirect:/main/remps";
    }

    /**
     * 编辑操作
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/main/reempe/{id}")
    public String toEditpage(@PathVariable("id") Integer id, ModelMap map){
        RoleEntity roleEntity = service.findById(id);
        map.addAttribute("reempe",roleEntity);
        return "role/edit";
    }
    @PutMapping("/main/reempe")
    public String updata(RoleEntity roleEntity){
        service.save(roleEntity);
        return "redirect:/main/remps";
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("/main/rempd/{id}")
    public  String deleteuser(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/main/remps";
    }
}
