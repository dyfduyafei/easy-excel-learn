package com.dyf.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.dyf.easyexcel.dao.DemoDao;
import javafx.scene.media.VideoTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author duyafei
 * @date 2024/1/10
 */
@RestController
public class TestRead {

    @Autowired
    private DemoDao demoDao;


    public static void main(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:demo.xlsx");
//        EasyExcel.read(file, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            dataList.forEach(System.out::println);
//        }, 2)).sheet().doRead();

        EasyExcel.read(file, DemoData.class, new DemoDataListener(null)).sheet(0).doRead();

//        try (ExcelReader excelReader = EasyExcel.read(file, DemoData.class, new DemoDataListener()).build()) {
//            // 构建一个sheet 这里可以指定名字或者no
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            // 读取一个sheet
//            excelReader.read(readSheet);
//        }


    }

    @PostMapping("/test")
    public void test() throws FileNotFoundException {
        System.out.println(demoDao);
        File file = ResourceUtils.getFile("classpath:demo.xlsx");
//        EasyExcel.read(file, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            dataList.forEach(System.out::println);
//        }, 2)).sheet().doRead();

        EasyExcel.read(file, DemoData.class, new DemoDataListener(demoDao)).sheet(0).doRead();


    }
}
