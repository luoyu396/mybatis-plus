package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.bean.Employee;
import com.example.mybatisplus.mapper.EmployeeMapper;
import com.example.mybatisplus.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanbb
 * @create 2022-01-27
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Override
    public String getNameById(Long id) {
        return this.baseMapper.getNameById(id);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return this.baseMapper.getEmployeeByName(name);
    }
}
