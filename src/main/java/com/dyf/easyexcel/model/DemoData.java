package com.dyf.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class DemoData {

    @ExcelProperty("用户名")
    private String username;

    private Date date;

    @ExcelProperty("数字")
    private Double doubleData;
}