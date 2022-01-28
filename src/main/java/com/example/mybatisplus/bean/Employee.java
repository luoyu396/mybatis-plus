package com.example.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author tanbb
 * @create 2022-01-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tbl_employee")
public class Employee {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String lastName;
    private String email;
    private Integer age;
    private String gender;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
