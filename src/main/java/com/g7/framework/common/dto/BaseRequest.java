package com.g7.framework.common.dto;

import java.io.Serializable;

/**
 * @author dreamyao
 * @title
 * @date 2018/8/25 下午12:04
 * @since 1.0.0
 */
public class BaseRequest implements Serializable{
	
	private static final long serialVersionUID = -4496867430298036989L;
	/**
	 * 请求标识号
	 */
	private String sid;

	/**
	 * 国际化语言标识:zh_CN 中文简体/zh_TW 中文繁体/en_SG 英语(新加波)(参照《国际与语言代码对应关系表》)
	 */
	private String language;

	/**
	 * 通用请求信息
	 */
	private ActionInfo actionInfo;

	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
