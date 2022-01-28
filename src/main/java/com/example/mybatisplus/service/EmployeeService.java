package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.bean.Employee;

import java.util.List;

/**
 * @author tanbb
 * @create 2022-01-27
 */
public interface EmployeeService extends IService<Employee> {

    String getNameById(Long id);

    List<Employee> getEmployeeByName(String name);
}
