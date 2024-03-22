package com.dyf.easyexcel.demo.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;


@Data
@ColumnWidth(20)
public class SignInfo {



    /**
     * 身份证
     */
    @ExcelProperty(value = "身份证号")
    private String id_card_no;

    /**
     * 银行卡号
     */

    @ExcelProperty(value = "银行卡号")
    private String bank_card_no;

    /**
     * 用户编号
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 员工手机号
     */
    @ExcelProperty(value = "手机号")
    private String mobile;



}
