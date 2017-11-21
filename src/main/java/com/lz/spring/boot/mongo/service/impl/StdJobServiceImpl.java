package com.lz.spring.boot.mongo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lz.spring.boot.mongo.dao.StdJobDao;
import com.lz.spring.boot.mongo.enums.DelEnums;
import com.lz.spring.boot.mongo.exception.ReqErrCodes;
import com.lz.spring.boot.mongo.model.StdJob;
import com.lz.spring.boot.mongo.param.StdJobFilter;
import com.lz.spring.boot.mongo.service.StdJobService;

import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
import cn.lz.cloud.common.util.DateUtil;
import cn.lz.cloud.common.util.UUID;

/**
 * 岗位信息Service接口实现类
 * 
 * @author YangMing
 * @date 2017年11月21日
 */
@Service
public class StdJobServiceImpl implements StdJobService {

	@Autowired
	private StdJobDao stdJobDao;

	protected Logger log = LoggerFactory.getLogger(StdJobServiceImpl.class);

	// 添加岗位信息
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	public StdJob insert(ReqObject<StdJob> data) {
		StdJob stdJob = data.getObject();
		// 根据登记人查询岗位信息，如果查到记录则抛出异常
		if (stdJobDao.selectByRegName(stdJob) != null) {
			log.error("已存在此登记人登记的岗位信息");
			throw ReqErrCodes.REG_NAME_EXIST.exception();
		}
		stdJob.setUuid(UUID.getUUID());
		stdJob.setCorpUuid(UUID.getUUID());
		stdJob.setRegTime(DateUtil.longDateTime());
		stdJob.setIsDel(DelEnums.ISDel_EXIST.getIsDel());
		return stdJobDao.insert(stdJob);
	}

	// 修改岗位信息
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	public StdJob update(ReqObject<StdJob> data) {
		StdJob stdJob = data.getObject();
		// 根据登记人查询岗位信息
		if (stdJobDao.selectByRegName(stdJob) != null) {
			log.error("已存在此登记人登记的岗位信息");
			throw ReqErrCodes.REG_NAME_EXIST.exception();
		}
		return stdJobDao.update(stdJob);
	}

	// 批量删除岗位信息
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	public Integer delete(ReqObject<List<String>> data) {
		List<String> list = data.getObject();
		if (list != null && list.size() > 0) {
			stdJobDao.delete(list);
		} else {
			log.error("删除信息为空，请选择删除信息");
			throw ReqErrCodes.NO_MESSAGE_DELETED.exception();
		}
		return list.size();
	}

	// 根据条件查询岗位信息列表
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	public ResList<StdJob> select(ReqObject<ReqQuery<StdJobFilter>> data) {
		ReqQuery<StdJobFilter> filter = data.getObject();
		ResList<StdJob> resList = stdJobDao.select(filter);
		return resList;
	}

}
