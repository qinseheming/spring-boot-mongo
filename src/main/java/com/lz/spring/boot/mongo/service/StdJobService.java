package com.lz.spring.boot.mongo.service;

import java.util.List;

import com.lz.spring.boot.mongo.model.StdJob;
import com.lz.spring.boot.mongo.param.StdJobFilter;

import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;

/**
 * 岗位信息 Service接口
 * 
 * @author YangMing
 * @date 2017年11月20日
 */
public interface StdJobService {
	/**
	 * 添加岗位信息
	 * 
	 * @param data
	 *            封装了要添加的岗位信息
	 * @return
	 */
	StdJob insert(ReqObject<StdJob> data);

	/**
	 * 根据uuid修改岗位信息
	 * 
	 * @param data
	 *            封装了修改后的岗位信息
	 * @return
	 */
	StdJob update(ReqObject<StdJob> data);

	/**
	 * 删除岗位信息（逻辑删除：将岗位信息的isDel修改为0）
	 * 
	 * @param data
	 *            封装了要删除的岗位信息的uuid
	 * @return 返回删除的数量
	 */
	Integer delete(ReqObject<List<String>> data);

	/**
	 * 根据条件查询岗位信息
	 * 
	 * @param data
	 *            封装了公司uuid/岗位代码/岗位类别等查询条件
	 * @return 返回查询结果
	 */
	ResList<StdJob> select(ReqObject<ReqQuery<StdJobFilter>> data);

}
