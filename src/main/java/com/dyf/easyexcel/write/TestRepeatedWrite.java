package com.dyf.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.dyf.easyexcel.model.DemoData;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author duyafei
 * @since 2024-01-10
 */
@Slf4j
public class TestRepeatedWrite {
    public static void main(String[] args) {
        String fileName = "excel/" + "repeatedWriteDemo.xlsx";
//        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
//            WriteSheet writeSheet = EasyExcel.writerSheet("写入同一个sheet").build();
//            for (int i = 0; i < 50; i++) {
//                excelWriter.write(
//                        TestWrite.data(1000)
//                        , writeSheet);
//            }
//        }

        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            for (int i = 0; i < 5; i++) {
                WriteSheet writeSheet = EasyExcel.writerSheet(i, i + "--写到不同的sheet").build();
                excelWriter.write(
                        TestWrite.data(1000)
                        , writeSheet);
            }
        }
    }
}
