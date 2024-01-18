package com.g7.framework.common.dto.pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dreamyao
 * @title
 * @date 2018/8/25 下午12:04
 * @since 1.0.0
 */
public class PagerData<T> extends Pager implements Serializable {
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 数据总数，满足条件的数量，非本次查询结果条数，
     * 本次查询的具体结果由dataList字段确定
     */
    private Integer total;
    /**
     * 具体的数据
     */
    private List<T> dataList = new ArrayList<>();

    public static <T> PagerData<T> create(Class<T> cls) {
        return new PagerData<>();
    }

    public static <T> PagerData<T> create() {
        return new PagerData<>();
    }

    public Integer getTotal() {
        return total;
    }

    public PagerData<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public PagerData<T> setDataList(List<T> dataList) {
        this.dataList = dataList;
        return this;
    }

    public PagerData<T> addData(T data) {
        this.dataList.add(data);
        return this;
    }

    public T getData(int index) {
        if (this.dataList == null) {
            return null;
        }
        return this.dataList.get(index);
    }

    public Integer getPages() {
        return pages;
    }

    public PagerData<T> setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PagerData{");
        sb.append("pages=").append(pages);
        sb.append(", total=").append(total);
        sb.append(", dataList=").append(dataList);
        sb.append('}');
        return sb.toString();
    }
}
