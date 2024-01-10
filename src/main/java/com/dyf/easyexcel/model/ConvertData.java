package com.dyf.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.dyf.easyexcel.read.convert.CustomGenderConvert;
import lombok.Data;


@Data
public class ConvertData {

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("生日")
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private String birthday;

    @ExcelProperty("数字")
    @NumberFormat("#.##%")
    private String doubleData;

    @ExcelProperty(value = "性别", converter = CustomGenderConvert.class)
    private Integer gender;
}