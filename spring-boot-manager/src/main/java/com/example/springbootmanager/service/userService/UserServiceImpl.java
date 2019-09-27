package com.example.springbootmanager.service.userService;

import com.example.springbootmanager.model.UserEntity;
import com.example.springbootmanager.repository.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现user增删改差的Service
 */
@Service
public class UserServiceImpl implements userService {
@Autowired
    userDao userdao;
@Override
public List<UserEntity> findAll(){
    return userdao.findAll();
}
@Override
    public void save(UserEntity userEntity){
     userdao.save(userEntity);
}
@Override
    public void deleteById(Integer id){
    userdao.deleteById(id);
}
@Override
    public UserEntity findById(Integer id){
return userdao.findById(id).get();
}
@Override
    public void updataById(UserEntity userEntity){
    userdao.save(userEntity);
}

    @Override
    public List<UserEntity> findByAccount(String account) {
        return userdao.findByAccount(account);
    }

    @Override
    public UserEntity findByaccount(String account) {
        return userdao.findByaccount(account);
    }

    @Override
    public List<UserEntity> findByPage(String account, String phone) {
        return userdao.findByPage(account,phone);
    }

    @Override
    public List<UserEntity> findBydeparmentname(String deparmentname) {
        return userdao.findBydeparmentname(deparmentname);
    }

    @Override
    public UserEntity findByUserid(Integer userid) {
        return userdao.findByUserid(userid);
    }
}
