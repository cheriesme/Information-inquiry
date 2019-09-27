package com.example.springbootmanager.service.loginService;

import com.example.springbootmanager.model.UserEntity;
import com.example.springbootmanager.repository.loginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class loginService {
    @Autowired
    private loginDao dao;
    public boolean verifyLogin(UserEntity user){
        List<UserEntity> userlist = dao.findByAccountAndPassword(user.getAccount(),user.getPassword());
return userlist.size()>0;
    }
}
