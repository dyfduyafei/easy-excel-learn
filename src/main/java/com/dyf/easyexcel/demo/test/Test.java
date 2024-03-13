package com.dyf.easyexcel.demo.test;

import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONObject;
import com.dyf.easyexcel.demo.model.HistoricalUsersSixImportDto;

import java.util.List;

/**
 * @author duyafei
 * @date 2024/2/24
 */
public class Test {
    public static void main(String[] args) {
        String fileName = "excel/" + "撞库失败.xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, HistoricalUsersSixImportDto.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板3").build();
            excelWriter.write(getData(), writeSheet);
        }
    }

    private static List<HistoricalUsersSixImportDto> getData() {
        String json = FileUtil.readUtf8String("车商撞库失败.json");
        List<HistoricalUsersSixImportDto> dataList = JSONObject.parseArray(json).toJavaList(HistoricalUsersSixImportDto.class);
        return dataList;
    }
}
