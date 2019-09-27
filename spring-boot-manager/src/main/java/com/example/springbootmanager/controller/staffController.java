package com.example.springbootmanager.controller;

import com.example.springbootmanager.model.DeparmentEntity;
import com.example.springbootmanager.model.StaffEntity;
import com.example.springbootmanager.service.deparmentService.deparmentServiceImpl;
import com.example.springbootmanager.service.staffService.staffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller for staff
 */
@Controller
public class staffController {
    @Autowired
    private staffServiceImpl service;
@Autowired
private deparmentServiceImpl deservice;
    /**
     * 显示所有岗位
     * @param map
     * @return
     */
    @GetMapping("/main/semps")
    public String list(ModelMap map){
        List<StaffEntity> list = service.findAll();
    map.addAttribute("semps",list);
    return "staff/list";
    }

    /**
     * 创建一个岗位
     *
     * @param map
     * @return
     */
    @GetMapping("/main/semp")
    public String getEntity(ModelMap map){
        List<DeparmentEntity> list = deservice.findAll();
        map.addAttribute("semp",list);
        return "staff/add";
    }
    @PostMapping("/main/semp")
    public String addEntity(StaffEntity staffEntity){
        service.save(staffEntity);
        return "redirect:/main/semps";
    }

    /**
     * 编辑
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/main/esemp/{id}")
    public String getpage( @PathVariable("id") Integer id, ModelMap map){
        StaffEntity staff = service.findById(id);
        map.addAttribute("date",staff);
        List<DeparmentEntity> list = deservice.findAll();
        map.addAttribute("semp",list);
        return "/staff/edit";
    }
    @PutMapping("/main/esemp")
    public String Add(StaffEntity staffEntity){
        service.save(staffEntity);
        return "redirect:/main/semps";
    }
    @DeleteMapping("/main/dsemp/{id}")
    public String delectstaff(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/main/semps";
    }
}
