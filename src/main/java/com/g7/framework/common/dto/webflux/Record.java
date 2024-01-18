package com.g7.framework.common.dto.webflux;

/**
 * @author dreamyao
 * @title
 * @date 2022/2/21 2:40 下午
 * @since 1.0.0
 */
class Record<E> {

    private E record;

    public E getRecord() {
        return record;
    }

    public void setRecord(E record) {
        this.record = record;
    }
}
