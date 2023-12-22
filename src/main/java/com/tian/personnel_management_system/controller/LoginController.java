package com.tian.personnel_management_system.controller;

import com.tian.personnel_management_system.pojo.Emp;
import com.tian.personnel_management_system.pojo.Result;
import com.tian.personnel_management_system.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService ;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
      log.info("ログイン：｛｝",emp);
      Emp date = empService.login(emp);
        return  date !=null? Result.success():Result.error("用戶登入失敗");
    }


}
