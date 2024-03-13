package com.dyf.easyexcel.demo.read.convert;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.dyf.easyexcel.demo.model.ConvertData;
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
public class TestConvert {
    public static void main(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:convertData.xlsx");
        EasyExcel.read(file, ConvertData.class, new PageReadListener<ConvertData>(dataList -> {
            log.info("保存数据: {}, {}", dataList.size(), dataList);
        }, 2)).sheet().doRead();
    }
}
