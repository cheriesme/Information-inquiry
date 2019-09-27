package com.example.springbootmanager.service.staffService;

import com.example.springbootmanager.model.StaffEntity;

import java.util.List;

public interface staffService {
    List<StaffEntity> findAll();
    void save(StaffEntity staffEntity);
    void deleteById(Integer id);
    StaffEntity findById(Integer id);
    void updataById(StaffEntity staffEntity);
}
