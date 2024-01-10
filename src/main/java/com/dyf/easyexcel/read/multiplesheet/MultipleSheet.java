package com.dyf.easyexcel.read.multiplesheet;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.dyf.easyexcel.model.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * <p>
 *
 * </p>
 *
 * @author duyafei
 * @since 2024-01-10
 */
@Slf4j
public class MultipleSheet {
    public static void main(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:demo.xlsx");
//        EasyExcel.read(file, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            log.info("保存数据: {}, {}", dataList.size(), dataList);
//        }, 4)).doReadAll();

        try (ExcelReader excelReader = EasyExcel.read(file).build()) {
            ReadSheet readSheet0 = EasyExcel.readSheet(0).head(DemoData.class)
                    .registerReadListener(new PageReadListener<DemoData>(dataList -> {
                        log.info("sheet0 保存数据: {}, {}", dataList.size(), dataList);
                    }, 4))
                    .build();

            ReadSheet readSheet1 = EasyExcel.readSheet(1).head(DemoData.class)
                    .registerReadListener(new PageReadListener<DemoData>(dataList -> {
                        log.info("sheet1 保存数据: {}, {}", dataList.size(), dataList);
                    }, 4))
                    .build();
            ReadSheet readSheet2 = EasyExcel.readSheet("第三个").head(DemoData.class)
                    .registerReadListener(new PageReadListener<DemoData>(dataList -> {
                        log.info("sheet2 保存数据: {}, {}", dataList.size(), dataList);
                    }, 4))
                    .build();
            excelReader.read(readSheet0, readSheet1, readSheet2);
        }

    }
}
