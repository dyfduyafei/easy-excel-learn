package com.dyf.easyexcel.read.pageread;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
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
public class PageRead {

    public static void main(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:demo.xlsx");
        EasyExcel.read(file, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            log.info("保存数据: {}, {}", dataList.size(), dataList);
        }, 2)).sheet().doRead();
    }
}
