package com.tian.personnel_management_system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tian.personnel_management_system.mapper.EmpMapper;
import com.tian.personnel_management_system.pojo.Emp;
import com.tian.personnel_management_system.pojo.PageBean;
import com.tian.personnel_management_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServicelmpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public void deleteById(Integer id) {
        empMapper.deleteById(id);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize , String name, Short gender,  LocalDate begin,
                         LocalDate end) {
        //ページ引数設定
        PageHelper.startPage(page,pageSize);
        //検索
        List<Emp> empList= empMapper.list(name,gender,begin,end);
        Page<Emp> p=(Page<Emp>)empList;
        //PageBeanパッケージ化
    PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
     return pageBean;
    }

    @Override
    public Emp getById(Integer id) {
        Emp date= empMapper.getById(id);
        return date;
    }

    @Override
    public void save(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.save(emp);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAnoPassword(emp);
    }
}
