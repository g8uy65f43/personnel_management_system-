package com.tian.personnel_management_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private int id;
    private String username;
    private String password;
    private String name;
    private short gender;
    private String image;
    private short job;
    private LocalDate entrydate;
    private int deptId;
    private LocalDateTime createTime;
    private  LocalDateTime updateTime;
}
