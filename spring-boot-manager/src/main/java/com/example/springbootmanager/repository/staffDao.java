package com.example.springbootmanager.repository;

import com.example.springbootmanager.model.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface staffDao extends JpaRepository<StaffEntity,Integer> {
}
