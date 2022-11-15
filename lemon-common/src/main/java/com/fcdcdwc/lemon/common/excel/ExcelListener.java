package com.fcdcdwc.lemon.common.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyandi
 * @program: attribute
 * @description: Excel
 * @date 2021-09-27 09:59:36
 */
public class ExcelListener<T> extends AnalysisEventListener<T> {

    List<T> list = new ArrayList<T>();

    Map<Integer, String> headMap = new HashMap<>();

    public ExcelListener(List<T> list) {
        this.list = list;
    }

    public ExcelListener(List<T> list, Map<Integer, String> headMap) {
        this.list = list;
        this.headMap = headMap;
    }

    //一行一行去读取excle内容
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        list.add(t);
    }

    //读取excel表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        this.headMap = headMap;
    }

    //读取完成后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

}
