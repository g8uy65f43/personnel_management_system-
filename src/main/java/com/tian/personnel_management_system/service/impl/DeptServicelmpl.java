package com.tian.personnel_management_system.service.impl;

import com.tian.personnel_management_system.mapper.DeptMapper;
import com.tian.personnel_management_system.pojo.Dept;
import com.tian.personnel_management_system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServicelmpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void save(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);

    }

    @Override
    public void upData(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.upData(dept);

    }

    @Override
    public Dept getUserById(Integer id) {

        return deptMapper.getUserById(id);
    }

}
