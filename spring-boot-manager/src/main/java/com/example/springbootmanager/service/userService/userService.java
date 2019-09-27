package com.example.springbootmanager.service.userService;

import com.example.springbootmanager.model.UserEntity;

import java.util.List;

public interface userService {
    List<UserEntity> findAll();
   void save(UserEntity userEntity);
    void deleteById(Integer id);
    UserEntity findById(Integer id);
    void updataById(UserEntity userEntity);
    List<UserEntity> findByAccount(String account);
    UserEntity findByaccount(String account);
    List<UserEntity> findByPage(String account,String phone);
    List<UserEntity> findBydeparmentname(String deparmentname);
    UserEntity findByUserid(Integer userid);
}
