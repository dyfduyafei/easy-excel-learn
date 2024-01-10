package com.dyf.easyexcel.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class DemoWriteData {

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("生日")
    private Date date;

    @ExcelProperty("数字")
    private Double doubleData;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;

}