package com.g7.framework.common.dto.webflux;

import java.util.List;

/**
 * <p>
 * Paged.Builder<GetAttachmentDto> builder = new Paged.Builder<>()
 * builder.total((int) page.getTotal()).currentPage(req.getPage().getCurrentPage()).pageSize(req.getPage().getPageSize()).data(collect).build()
 * </p>
 * @author dreamyao
 * @title
 * @date 2018/8/25 下午12:04
 * @since 1.0.0
 */
public class Paged<E> extends Record<List<E>> {

    /**
     * 是否计算了总和
     */
    private boolean countTotal = false;

    /**
     * 是否查询了全部
     */
    private boolean fetchAll = false;

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 当前页数
     */
    private int currentPage;

    /**
     * 当前分页大小
     */
    private int pageSize;

    /**
     * 构建请使用PagedResult.Builder构建
     */
    public Paged() {

    }

    public boolean isCountTotal() {
        return countTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PagedResult");
        builder.append("[");
        builder.append("countTotal=").append(countTotal).append(",");
        builder.append("fetchAll=").append(fetchAll).append(",");
        builder.append("total=").append(total).append(",");
        builder.append("totalPage=").append(totalPage).append(",");
        builder.append("currentPage=").append(currentPage).append(",");
        builder.append("pageSize=").append(pageSize);
        builder.append("]");

        return builder.toString();
    }

    public static class Builder<E> {

        private final Paged<E> paged;

        public Builder() {
            this.paged = new Paged<E>();
        }

        public Builder(int currentPage) {
            if (currentPage < 1) {
                throw new RuntimeException("currentPage error:" + currentPage);
            }
            this.paged = new Paged<E>();
            this.paged.currentPage = currentPage;
        }

        public Builder(int currentPage, int pageSize) {
            if (currentPage < 1) {
                throw new RuntimeException("currentPage error:" + currentPage);
            }

            if (pageSize < 1) {
                throw new RuntimeException("pageSize error:" + pageSize);
            }

            this.paged = new Paged<E>();
            this.paged.currentPage = currentPage;
            this.paged.pageSize = pageSize;
        }

        public Builder<E> total(int total) {
            if (total < 0) {
                throw new RuntimeException("total error:" + total);
            }
            this.paged.total = total;
            return this;
        }

        public Builder<E> currentPage(int currentPage) {
            if (currentPage < 1) {
                throw new RuntimeException("currentPage error:" + currentPage);
            }
            this.paged.currentPage = currentPage;
            return this;
        }

        public Builder<E> pageSize(int pageSize) {
            if (pageSize < 1) {
                throw new RuntimeException("pageSize error:" + pageSize);
            }

            this.paged.pageSize = pageSize;
            return this;
        }

        public Builder<E> countTotal(boolean countTotal) {
            this.paged.countTotal = countTotal;
            return this;
        }

        public Builder<E> fetchAll(boolean fetchAll) {
            this.paged.fetchAll = fetchAll;
            return this;
        }

        public Builder<E> data(List<E> data) {
            this.paged.setRecord(data);
            return this;
        }

        public Paged<E> build() {

            if (this.paged.getRecord() == null) {
                throw new RuntimeException("pagedResult's data list is null, if you means not found, you should return empty list instead.");
            }

            //如果获取全部结果集
            if (this.paged.fetchAll) {
                this.paged.currentPage = 1;
                this.paged.totalPage = 1;
                this.paged.total = this.paged.getRecord().size();
                this.paged.pageSize = this.paged.total;

                return this.paged;
            }

            //计算
            if (this.paged.countTotal || this.paged.total != null) {
                this.paged.totalPage = computeTotalPage(this.paged.total, this.paged.pageSize);
            }

            return this.paged;
        }

        private Integer computeTotalPage(Integer total, int pageSize) {
            if (total == null || total < 0) {
                throw new RuntimeException("total count illegal:" + total);
            }

            if (pageSize <= 0) {
                throw new RuntimeException("pageSize error:" + pageSize);
            }

            int tmp = total / pageSize;
            if (total % pageSize != 0) {
                tmp = tmp + 1;
            }

            return tmp;
        }
    }
}
