package com.example.springbootmanager.service.roleService;

import com.example.springbootmanager.model.RoleEntity;
import com.example.springbootmanager.repository.roleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class roleServiceImpl implements roleService{
    @Autowired
    roleDao roledao;
    @Override
    public List<RoleEntity> findAll(){
        return roledao.findAll();
    }
    @Override
    public void save(RoleEntity roleEntity){
        roledao.save(roleEntity);
    }
    @Override
    public void deleteById(Integer id){
        roledao.deleteById(id);
    }
    @Override
    public RoleEntity findById(Integer id){
        return roledao.findById(id).get();
    }
    @Override
    public void updataById(RoleEntity roleEntity){
        roledao.save(roleEntity);
    }
}
