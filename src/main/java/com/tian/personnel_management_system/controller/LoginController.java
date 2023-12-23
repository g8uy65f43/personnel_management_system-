package com.tian.personnel_management_system.controller;

import com.tian.personnel_management_system.pojo.Emp;
import com.tian.personnel_management_system.pojo.Result;
import com.tian.personnel_management_system.service.EmpService;
import com.tian.personnel_management_system.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService ;




    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
      log.info("ログイン：｛｝",emp);
      Emp date = empService.login(emp);
      if(date != null){
          Map <String,Object> claims = new HashMap<>();
          claims.put("id",date.getId());
          claims.put("name",date.getName());
          claims.put("username",date.getUsername());
          String jwt =  JwtUtils.generateJwt(claims);
        return Result.success(jwt);
      }



        return  Result.error("ログイン失敗");
    }



}
