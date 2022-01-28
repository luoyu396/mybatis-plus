package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author tanbb
 * @create 2022-01-27
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Select("SELECT last_name FROM tbl_employee WHERE id = #{id} ")
    String getNameById(@Param("id") Long id);

    List<Employee> getEmployeeByName(@Param("lastName") String name);
}
