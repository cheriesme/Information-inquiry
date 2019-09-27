package com.example.springbootmanager.repository;

import com.example.springbootmanager.model.DeparmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface deparmentDao extends JpaRepository<DeparmentEntity,Integer> {

}
