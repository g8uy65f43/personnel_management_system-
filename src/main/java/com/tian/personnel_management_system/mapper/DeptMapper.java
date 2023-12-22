package com.tian.personnel_management_system.mapper;

import com.tian.personnel_management_system.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    public void insert(Dept data);
    @Update("update dept set update_time = #{updateTime}, name = #{name} where id = #{id}")
    public void upData(Dept data);

    @Select("select * from dept")
    public List<Dept> list();
    @Delete("delete from dept where id = #{id}")
    public void deleteById(Integer id);
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    public Dept getUserById(Integer id);
}
