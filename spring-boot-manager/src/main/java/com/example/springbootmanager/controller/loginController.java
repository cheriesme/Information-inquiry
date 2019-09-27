package com.example.springbootmanager.controller;

import com.example.springbootmanager.model.UserEntity;
import com.example.springbootmanager.service.loginService.loginService;
import com.example.springbootmanager.service.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {
    @Autowired
    private loginService  loginService;
    @Autowired
    private UserServiceImpl service;
    @Autowired

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Map<String,Object> map){
        map.put("msg","");
        return "index";
    }

    @GetMapping("/loginError")
    public String loginError(Map<String,Object> map){
        map.put("msg","用户名或密码错误！");
        return "index";
    }
    @GetMapping("/loginErrorforPermission")
    public String loginErrorforPermission(Map<String,Object> map){
        map.put("msg","没用权限访问！");
        return "index";
    }

    @GetMapping("/loginDBError")
    public String loginDBError(Map<String,Object> map){
        map.put("msg","链接数据库出错！");
        return "index";
    }

    @PostMapping("/user/login")
    public String loginVerify(String account, String password, HttpSession session, ModelMap map){
        UserEntity user = new UserEntity();
        user.setAccount(account);
        user.setPassword(password);
UserEntity userk = service.findByaccount(account);
String k = userk.getRolename();
        boolean verify = loginService.verifyLogin(user);
        try {
            if (verify) {
                session.setAttribute("account", account);

              if ("管理员".equals(k)) {
//                List<UserEntity> list = service.findByAccount(account);
//                map.addAttribute("login",list);
                  System.out.println("登陆成功");
                  return "main";
              }else if("普通员工".equals(k)){
                  return "person/mainperson";
              }else {
                return "redirect:/loginErrorforPermission";
              }
            } else {
                return "redirect:/loginError";
            }
        }
        catch (Exception ex)
        {
            return "redirect:/loginDBError";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("account");
        return "redirect:/login";
    }
//    @PostMapping(value = "/user/login")
//    public  String login(@RequestParam("account") String account,
//                         @RequestParam("password") String password, Map<String,Object> map,HttpSession session){
//        /**
//         * 登陆成功返回操作界面;登陆失败返回
//          */
//        if (!StringUtils.isEmpty(account) && "123456".equals(password)){
//            //返回操作界面;返回一个session
//            session.setAttribute("loginuser",account);
//            return "redirect:/main";
//        }else {
//            //返回登录界面
//            map.put("msg","登陆失败！请重试");
//            return "index";
//        }
//
//    }
}
