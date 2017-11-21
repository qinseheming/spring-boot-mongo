package com.lz.spring.boot.mongo.enums;
/**
 * 删除字段枚举类
 * @author YangMing
 * @date 2017年11月20日
 */
public enum DelEnums {
	IsDel_NOT_EXIST("0", "已删除"),
	ISDel_EXIST("1", "未删除"),
	;
	private String isDel;
	private String msg;
	
	private DelEnums(String isDel, String msg) {
		this.isDel = isDel;
		this.msg = msg;
	}
	
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
