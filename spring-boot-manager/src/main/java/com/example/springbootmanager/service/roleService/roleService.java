package com.example.springbootmanager.service.roleService;

import com.example.springbootmanager.model.RoleEntity;

import java.util.List;

public interface roleService {
    List<RoleEntity> findAll();
    void save(RoleEntity roleEntity);
    void deleteById(Integer id);
    RoleEntity findById(Integer id);
    void updataById(RoleEntity roleEntity);
}
