package com.example.springbootmanager.service.staffService;

import com.example.springbootmanager.model.StaffEntity;
import com.example.springbootmanager.repository.staffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class staffServiceImpl implements staffService{
    @Autowired
    private staffDao staffdao;
    @Override
    public List<StaffEntity> findAll() {
        return staffdao.findAll();
    }

    @Override
    public void save(StaffEntity staffEntity) {
staffdao.save(staffEntity);
    }

    @Override
    public void deleteById(Integer id) {
staffdao.deleteById(id);
    }

    @Override
    public StaffEntity findById(Integer id) {
        return staffdao.findById(id).get();
    }

    @Override
    public void updataById(StaffEntity staffEntity) {
staffdao.save(staffEntity);
    }
}
