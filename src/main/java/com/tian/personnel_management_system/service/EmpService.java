package com.tian.personnel_management_system.service;

import com.tian.personnel_management_system.pojo.Emp;
import com.tian.personnel_management_system.pojo.PageBean;

import java.time.LocalDate;

public interface EmpService {

     void deleteById(Integer id) ;

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    Emp getById(Integer id);

    void save(Emp date);

    void update(Emp emp);

    Emp login(Emp emp);
}
