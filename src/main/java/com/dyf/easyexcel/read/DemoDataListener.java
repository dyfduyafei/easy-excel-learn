package com.dyf.easyexcel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.dyf.easyexcel.dao.DemoDao;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author duyafei
 * @date 2024/1/10
 */
public class DemoDataListener implements ReadListener<DemoData> {

    private final DemoDao demoDao;


    /**
     * 单次缓存的数据量
     */
    public static final int BATCH_COUNT = 2;
    /**
     * 临时存储
     */
    private List<DemoData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    public DemoDataListener(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    @Override
    public void invoke(DemoData data, AnalysisContext analysisContext) {
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            // 存储完成清理 list
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    private void saveData() {
        demoDao.saveData(cachedDataList);
//        System.out.println("保存数据: " + cachedDataList.size() + "----" + cachedDataList);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("doAfterAllAnalysed");
        saveData();
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        System.out.println("onException: " + cachedDataList);
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println("invokeHead");
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        System.out.println("extra");
    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return ReadListener.super.hasNext(context);
    }

}
