package com.lz.spring.boot.mongo.exception;

import cn.lz.cloud.common.exception.code.ErrorCode0;

public class ReqErrCodes {
	public static final ErrorCode0 FILTER_ERROR_CORP = new ErrorCode0("REQ001", "请输入查询条件[{0}]");
	public static final ErrorCode0 NO_MESSAGE_DELETED = new ErrorCode0("REQ002", "删除信息为空，请选择删信息");
	public static final ErrorCode0 REG_NAME_EXIST = new ErrorCode0("REQ003", "已存在此登记人登记的岗位信息");
}
