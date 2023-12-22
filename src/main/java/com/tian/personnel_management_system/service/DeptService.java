package com.tian.personnel_management_system.service;

import com.tian.personnel_management_system.pojo.Dept;

import java.util.List;

public interface DeptService {

      List<Dept> list();
      void  deleteById(Integer id);


    void save(Dept dept);

    void upData(Dept dept);

    Dept getUserById(Integer id);
}
