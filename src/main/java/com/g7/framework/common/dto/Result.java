package com.g7.framework.common.dto;

/**
 * Result&lt;XXX&gt; result = Result.create();<br/>
 * ...<br/>
 * return result.success();<br/>
 * or <br/>
 * return result.success(data);<br/>
 * or <br/>
 * return result.fail("SomeErrorCode","SomeDescription")<br/>
 * or <br/>
 * return result.fail("SomeErrorCode") <br/>
 * or you can do chained callings like below:<br/>
 *
 * result.data(data).code("SomeCode").description("SomeDescription").success();<br/>
 * <br/>
 * @author dreamyao
 * @title
 * @date 2018/8/25 下午12:04
 * @since 1.0.0
 */
public class Result<T> extends BaseResult {

	/**
	 * 返回数据，可为基本类型（包装类），可以为其它可序列化对象
	 */
	private T data;

	public static <T> Result<T> create() {
		Result<T> result = new Result<T>();
		result.setSuccess(false);
		return result;
	}

	public Result<T> success(){
		success(null);
		return this;
	}

	public Result<T> success(T data){
		this.setSuccess(true);
		this.data = data;
		return this;
	}

	public Result<T> fail(String code, String description){
		this.setSuccess(false);
		this.setCode(code);
		this.setDescription(description);
		return this;
	}

	public Result<T> fail(String code){
		fail(code, null);
		return this;
	}

	public Result<T> code(String code){
		this.setCode(code);
		return this;
	}

	public Result<T> description(String description){
		this.setDescription(description);
		return this;
	}

	public Result<T> sid(String sid){
		this.setSid(sid);
		return this;
	}

	public Result<T> data(T data){
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
