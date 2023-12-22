package com.tian.personnel_management_system.mapper;

import com.tian.personnel_management_system.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {




  public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

@Delete("delete from emp where id = #{id}")
 public void deleteById(Integer id);
  @Select("select * from emp where id = #{id}")
  Emp getById(Integer id);
  @Insert("insert into emp(USERNAME, NAME, GENDER, IMAGE, JOB, ENTRYDATE, DEPT_ID, CREATE_TIME, UPDATE_TIME) values" +
          " (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
  void save(Emp emp);

  void update(Emp emp);
 @Select("select * from emp where username = #{username} and password = #{password}" )
 Emp getByUsernameAnoPassword(Emp emp);
}
