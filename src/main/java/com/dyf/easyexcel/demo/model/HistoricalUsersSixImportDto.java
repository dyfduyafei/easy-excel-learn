package com.dyf.easyexcel.demo.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class HistoricalUsersSixImportDto {

    /**
     * 车商
     */
    @ExcelProperty(value = "二网名称")
    private String dealerName;

    /**
     * 车商类型
     */
    @ExcelProperty(value = "车商类型")
    private Integer dealerType;

    /**
     * 身份证
     */
    @ExcelProperty(value = "身份证号")
    private String idCardNo;

    /**
     * 银行卡号
     */

    @ExcelProperty(value = "银行卡号")
    private String bankNo;

    /**
     * 用户编号
     */
    @ExcelProperty(value = "姓名")
    private String userName;

    /**
     * 员工手机号
     */
    @ExcelProperty(value = "手机号")
    private String mobile;

    @ExcelProperty(value = "失败原因")
    private String errorMsg;

}
