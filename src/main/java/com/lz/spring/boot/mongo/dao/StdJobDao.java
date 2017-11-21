package com.lz.spring.boot.mongo.dao;

import java.util.List;

import com.lz.spring.boot.mongo.model.StdJob;
import com.lz.spring.boot.mongo.param.StdJobFilter;

import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;

/**
 * 岗位信息增删改查DAO层接口
 * 
 * @author YangMing
 * @date 2017年11月20日
 */
public interface StdJobDao {
	/**
	 * 添加岗位信息
	 * 
	 * @param stdJob
	 *            要添加的岗位信息
	 * @return
	 */
	StdJob insert(StdJob stdJob);

	/**
	 * 根据uuid修改岗位信息
	 * 
	 * @param stdJob
	 *            修改后的岗位信息
	 * @return
	 */
	StdJob update(StdJob stdJob);

	/**
	 * 删除岗位信息（逻辑删除：将岗位信息的isDel修改为0）
	 * 
	 * @param list
	 *            要删除的岗位信息的uuid
	 * @return 返回删除的数量
	 */
	int delete(List<String> list);

	/**
	 * 根据条件查询岗位信息
	 * 
	 * @param filter
	 *            封装了公司uuid/岗位代码/岗位类别等查询条件
	 * @return 返回查询结果列表
	 */
	ResList<StdJob> select(ReqQuery<StdJobFilter> filter);

	/**
	 * 根据登记人查询岗位信息
	 * 
	 * @param stdJob
	 *            封装了登记人的岗位信息
	 * @return 如果存在，返回查询到的结果，否则返回null
	 */
	public StdJob selectByRegName(StdJob stdJob);
}
