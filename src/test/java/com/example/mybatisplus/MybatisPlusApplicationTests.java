package com.example.mybatisplus;

import com.example.mybatisplus.bean.Employee;
import com.example.mybatisplus.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@MapperScan("com.example.mybatisplus.mapper")
class MybatisPlusApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        List<Employee> employees = employeeService.list();
        employees.forEach(System.out::println);
    }

    @Test
    void testInsert() {
        Employee employee = new Employee();
        employee.setLastName("z22s");
        employee.setAge(31);
        employee.setGender("2");
        employee.setEmail("33333@qq.com");
        employeeService.save(employee);
    }

    @Test
    void testUpdate() {
        Employee employee = employeeService.getById(5);
        employee.setGender("1");
        employeeService.saveOrUpdate(employee);
    }

    @Test
    void testCustomQuery1() {
       String name = employeeService.getNameById(2L);
       System.out.println(name);
    }

    @Test
    void testCustomQuery2() {
        List<Employee> employee = employeeService.getEmployeeByName("zs");
        System.out.println(employee);
    }
}
