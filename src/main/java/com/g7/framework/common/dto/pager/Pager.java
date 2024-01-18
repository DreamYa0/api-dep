package com.g7.framework.common.dto.pager;

import java.io.Serializable;

/**
 * @author dreamyao
 * @title
 * @date 2018/8/25 下午12:04
 * @since 1.0.0
 */
public class Pager implements Serializable {

    private static final int DEFAULT_PAGE_NUM = 1;
    private static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 页号，从1开始
     */
    private Integer pageNum = DEFAULT_PAGE_NUM;
    /**
     * 每页的大小
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 是否获取总数
     */
    private boolean count = false;

    public Pager() {
    }

    public Pager(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Pager(Integer pageNum, Integer pageSize, boolean count) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null) {
            throw new RuntimeException("pageNum is null");
        }
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            throw new RuntimeException("pageSize is null");
        }
        this.pageSize = pageSize;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pager{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
