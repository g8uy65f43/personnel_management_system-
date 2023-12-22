package com.tian.personnel_management_system.controller;

import com.tian.personnel_management_system.pojo.Dept;
import com.tian.personnel_management_system.pojo.Result;
import com.tian.personnel_management_system.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //log作成、log.infoじゃなくて、フレームの日誌使うほうがいい,そしてアノテーションあります
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result list(){
        log.info("全部門データ検索");
        List<Dept> deptList= deptService.list();
        return Result.success(deptList);

    }

    @DeleteMapping("/{id}")
    public Result deleteByid(@PathVariable Integer id) {
        log.info("部門削除{}",id);
        deptService.deleteById(id);
        return Result.success();

    }
  @PostMapping
    public Result save(@RequestBody Dept dept) {
        log.info("部門データ作成",dept);
        deptService.save(dept);

      return Result.success();

    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("IDにて部門データ検索!");
        Dept dept= deptService.getUserById(id);
        log.info(dept.toString());
        return Result.success(dept);

    }

    @PutMapping
    public Result upData(@RequestBody  Dept dept) {
        log.info("部門データ更新");
        deptService.upData(dept);
        return Result.success();

    }






}
