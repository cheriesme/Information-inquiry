package com.example.springbootmanager.repository;

import com.example.springbootmanager.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roleDao extends JpaRepository<RoleEntity,Integer> {
}
