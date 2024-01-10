package com.dyf.easyexcel.read;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
public class DemoData {

    @ExcelProperty("用户名")
    private String username;

    private Date date;

    @ExcelProperty("数字")
    private Double doubleData;
}