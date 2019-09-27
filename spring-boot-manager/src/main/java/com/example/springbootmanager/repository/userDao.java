package com.example.springbootmanager.repository;

import com.example.springbootmanager.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface userDao extends JpaRepository<UserEntity,Integer> {
    public List<UserEntity> findByAccount(String account);
    UserEntity findByaccount(String account);
    @Query(value ="select * from user where if(?1 !='',account=?1,1=1) and if(?2 !='',phone=?2,1=1)",nativeQuery = true)
    List<UserEntity> findByPage(String account,String phone);
List<UserEntity> findBydeparmentname(String deparmentname);
UserEntity findByUserid(Integer userid);
}