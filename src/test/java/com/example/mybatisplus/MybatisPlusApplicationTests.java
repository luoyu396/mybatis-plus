package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.bean.Employee;
import com.example.mybatisplus.bean.Shop;
import com.example.mybatisplus.mapper.ShopMapper;
import com.example.mybatisplus.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.example.mybatisplus.mapper")
class MybatisPlusApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ShopMapper shopMapper;

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

    @Test
    void testDel() {
        employeeService.removeById(5);
    }

    @Test
    void testPage() {
        Page<Employee> page = new Page<>(1,2);
        employeeService.page(page, new LambdaQueryWrapper<Employee>().eq(Employee::getLastName, "tan"));
        List<Employee> employeeList = page.getRecords();
        employeeList.forEach(System.out::println);
        System.out.println("???????????????:" + page.getTotal());
        System.out.println("??????????????????:" + page.getCurrent());
        System.out.println("???????????????:" + page.getPages());
        System.out.println("?????????????????????????????????:" + page.getSize());
        System.out.println("??????????????????:" + page.hasPrevious());
        System.out.println("??????????????????:" + page.hasNext());
    }

    @Test
    void testShop() {
        // A???B?????????????????????
        Shop A = shopMapper.selectById(1L);
        Shop B = shopMapper.selectById(1L);
        // B??????????????????
        B.setPrice(9000);
        int result = shopMapper.updateById(B);
        if (result == 1) {
            System.out.println("B?????????????????????!");
        } else {
            System.out.println("B?????????????????????!");
        }
        // A??????????????????
        A.setPrice(8500);
        int result2 = shopMapper.updateById(A);
        if (result2 == 1) {
            System.out.println("A?????????????????????!");
        } else {
            System.out.println("A?????????????????????!");
        }
        // ????????????
        System.out.println(shopMapper.selectById(1L));
    }

    @Test
    void testWrapper1() {
        // ?????????????????????'j'???????????????20????????????????????????????????????
        QueryWrapper<Employee> wrapper = new QueryWrapper<Employee>()
                .likeRight("last_name", "z")
                .gt("age", 20)
                .isNotNull("email");
        List<Employee> list = employeeService.list(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    void testWrapper2() {
        // ?????????????????????'t'???????????????20????????????????????????????????????
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<Employee>()
                .like(Employee::getLastName,"t")
                .gt(Employee::getAge,20)
                .isNotNull(Employee::getEmail);
        List<Employee> list = employeeService.list(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    void testWrapper3() {
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<Employee>()
                .set(Employee::getAge, 10)
                .set(Employee::getEmail, "tanbinbin@163.com")
                .like(Employee::getLastName, "t")
                .gt(Employee::getAge, 20);
        employeeService.update(null, wrapper);
    }
}
