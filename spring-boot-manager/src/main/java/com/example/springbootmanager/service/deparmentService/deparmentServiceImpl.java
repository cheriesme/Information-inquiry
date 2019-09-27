package com.example.springbootmanager.service.deparmentService;

import com.example.springbootmanager.model.DeparmentEntity;
import com.example.springbootmanager.repository.deparmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class deparmentServiceImpl implements deparmentService{
    @Autowired
    private deparmentDao deparmentdao;
    @Override
    public List<DeparmentEntity> findAll() {
        return deparmentdao.findAll();
    }

    @Override
    public void save(DeparmentEntity deparmentEntity) {
deparmentdao.save(deparmentEntity);
    }

    @Override
    public void deleteById(Integer id) {
deparmentdao.deleteById(id);
    }

    @Override
    public DeparmentEntity findById(Integer id) {
        return deparmentdao.findById(id).get();
    }

    @Override
    public void updataById(DeparmentEntity deparmentEntity) {
        deparmentdao.save(deparmentEntity);
    }
}
