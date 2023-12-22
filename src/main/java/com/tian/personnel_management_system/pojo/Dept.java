package com.tian.personnel_management_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private int id ;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
