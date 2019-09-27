package com.example.springbootmanager.repository;

import com.example.springbootmanager.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface loginDao extends CrudRepository<UserEntity, String> {
    public List<UserEntity> findByAccountAndPassword(String account, String password);
    }


