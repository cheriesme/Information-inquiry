package com.example.springbootmanager.service.deparmentService;

import com.example.springbootmanager.model.DeparmentEntity;

import java.util.List;

public interface deparmentService {
    List<DeparmentEntity> findAll();
    void save(DeparmentEntity deparmentEntity);
    void deleteById(Integer id);
    DeparmentEntity findById(Integer id);
    void updataById(DeparmentEntity deparmentEntity);
}
