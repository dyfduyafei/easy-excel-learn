package com.dyf.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author duyafei
 * @date 2024/1/10
 */
public class TestRead {
    public static void main(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:demo.xlsx");
//        EasyExcel.read(file, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            dataList.forEach(System.out::println);
//        }, 2)).sheet().doRead();

        EasyExcel.read(file, DemoData.class,new DemoDataListener()).sheet().doRead();


    }
}
