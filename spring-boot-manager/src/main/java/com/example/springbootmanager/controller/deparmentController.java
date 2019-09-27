package com.example.springbootmanager.controller;

import com.example.springbootmanager.model.DeparmentEntity;
import com.example.springbootmanager.service.deparmentService.deparmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * deparment for controller
 */
@Controller
public class deparmentController {
    @Autowired
    private deparmentServiceImpl service;

    /**
     * 显示所有数据库的内的部门信息
     *
     * @param map
     * @return
     */
    @GetMapping("/main/demps")
    public String list(ModelMap map) {
        List<DeparmentEntity> list = service.findAll();
        map.put("demps", list);
        return "/deparment/list";
    }

    /**
     * 新建部门
     *
     * @return
     */
    @GetMapping("/main/demp")
    public String gettopage() {
        return "/deparment/add";
    }

    @PostMapping("/main/demp")
    public String adddeparment(DeparmentEntity deparmentEntity) {
        service.save(deparmentEntity);
        return "redirect:/main/demps";
    }

    /**
     * 编辑部门信息
     *
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/main/delemp/{id}")
    public String gettopage(@PathVariable("id") Integer id, ModelMap map) {
        DeparmentEntity deparmentEntity = service.findById(id);
        map.addAttribute("delemp", deparmentEntity);
        return "/deparment/edit";
    }
    @PutMapping("/main/delemp")
    public String add(DeparmentEntity deparmentEntity) {
        service.save(deparmentEntity);
        return "redirect:/main/demps";
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/main/ddemp/{id}")
    public String Deletepage(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/main/demps";
    }
}

