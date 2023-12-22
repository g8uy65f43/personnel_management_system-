package com.tian.personnel_management_system.controller;

import com.tian.personnel_management_system.pojo.Emp;
import com.tian.personnel_management_system.pojo.PageBean;
import com.tian.personnel_management_system.pojo.Result;
import com.tian.personnel_management_system.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.concurrent.RecursiveTask;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
                       ){

        log.info("ページ検索、引数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean= empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
    @GetMapping("/{id}")
     public Result getById(@PathVariable Integer id){
        log.info("Idで教諭データー検索");
        Emp date = empService.getById(id);
        return Result.success(date);

    }
    @PostMapping
    public Result save(@RequestBody Emp date){
        log.info("教諭データー追加");
        empService.save(date);
        return Result.success();
    }
    @PutMapping()
    public Result update(@RequestBody Emp emp){
        log.info("データ更新{}",emp);
        empService.update(emp);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("教諭データ削除");
        empService.deleteById(id);
        return Result.success();
    }
 }
