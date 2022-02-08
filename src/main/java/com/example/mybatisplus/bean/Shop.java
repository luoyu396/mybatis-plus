package com.example.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author tanbb
 * @create 2022-02-08
 */
@Data
public class Shop {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
