package com.dyf.easyexcel.demo.test;

import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyf.easyexcel.demo.model.HistoricalUsersSixImportDto;
import com.dyf.easyexcel.demo.model.SignInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duyafei
 * @date 2024/2/24
 */
public class Test2 {
    public static void main(String[] args) {
        String fileName = "excel/" + "2024签约信息.xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, SignInfo.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板3").build();
            excelWriter.write(getData(), writeSheet);
        }
    }

    private static List<SignInfo> getData() {
        String json = FileUtil.readUtf8String("signInfo.json");
        List<SignInfo> dataList = JSONObject.parseArray(json).toJavaList(SignInfo.class);

        return dataList;
    }
}
