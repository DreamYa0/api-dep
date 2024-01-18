package com.g7.framework.common.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author dreamyao
 * @title
 * @date 2018/8/25 下午12:04
 * @since 1.0.0
 */
public class Request<T> extends BaseRequest {

	/**  */
	private static final long serialVersionUID = 1L;
	/**
	 * 请求数据，可为基本类型（包装类），可以为其它可序列化对象
	 */
	@Valid
	@NotNull
	private T data;

	public Request(){

	}

	public Request(T data){
		this.data = data;
	}

	public static <T> Request<T> create() {
		return new Request<T>();
	}

	public Request<T> sid(String sid){
		this.setSid(sid);
		return this;
	}

	public Request<T> data(T data){
		this.data = data;
		return this;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
