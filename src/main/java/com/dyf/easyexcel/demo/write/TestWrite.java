package com.dyf.easyexcel.demo.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.dyf.easyexcel.demo.model.DemoData;
import com.dyf.easyexcel.demo.model.DemoWriteData;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author duyafei
 * @since 2024-01-10
 */
public class TestWrite {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "excel/" + "writeDemo.xlsx";

        EasyExcel.write(fileName, DemoWriteData.class)
                .sheet("模板1")
                .doWrite(() -> {
                    return data(10);
                });
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板2")
                .doWrite(data(10));


        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板3").build();
            WriteSheet writeSheet2 = EasyExcel.writerSheet("模板2").build();
            excelWriter.write(data(10), writeSheet);
            excelWriter.write(data(10), writeSheet2);
        }

    }

    public static List<DemoData> data(int dataNum) {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < dataNum; i++) {
            DemoData data = new DemoData();
            data.setUsername("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
