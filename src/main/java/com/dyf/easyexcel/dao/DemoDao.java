package com.dyf.easyexcel.dao;

import com.dyf.easyexcel.model.DemoData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duyafei
 * @date 2024/1/10
 */
@Service
public class DemoDao {

    public void saveData(List<DemoData> cachedDataList) {
        System.out.println("demodao.saveData" + cachedDataList.size() + "----" + cachedDataList);
    }
}
