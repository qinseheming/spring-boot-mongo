package com.lz.spring.boot.mongo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.lz.spring.boot.mongo.dao.StdJobDao;
import com.lz.spring.boot.mongo.enums.DelEnums;
import com.lz.spring.boot.mongo.model.StdJob;
import com.lz.spring.boot.mongo.param.StdJobFilter;

import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
import cn.lz.cloud.common.util.DateUtil;
import cn.lz.cloud.common.util.Pagination;

/**
 * 岗位信息DAO接口实现类
 * 
 * @author YangMing
 * @date 2017年11月21日
 */
@Repository
public class StdJobDaoImpl implements StdJobDao {

	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	// 根据登记人查询岗位信息
	public StdJob selectByRegName(StdJob stdJob) {
		if (stdJob.getRegName() != null && !"".equals(stdJob.getRegName())) {
			Query query = new Query();
			Criteria criteria = Criteria.where(StdJob.REG_NAME).is(stdJob.getRegName());
			query.addCriteria(criteria);
			StdJob resultStdJob = mongoTemplate.findOne(query, StdJob.class);
			return resultStdJob;
		}
		return null;
	}

	// 新增
	@Override
	public StdJob insert(StdJob stdJob) {
		mongoTemplate.save(stdJob);
		return stdJob;
	}

	// 更新
	@Override
	public StdJob update(StdJob stdJob) {
		Query query = new Query();
		Criteria criteria = Criteria.where(StdJob.UUID).is(stdJob.getUuid());
		query.addCriteria(criteria);
		Update update = new Update();
		// TODO 内嵌文档修改
		// 不能修改uuid、公司uuid、登记时间、登记人、是否删除
		update.set(StdJob.JOB_CODE, stdJob.getJobCode()).set(StdJob.CATEGORY, stdJob.getCategory())
				.set(StdJob.JOB_DESC, stdJob.getJobDesc()).set(StdJob.JOB_REQUIRE, stdJob.getJobRequire())
				.set(StdJob.JOB_LEVEL, stdJob.getJobLevel()).set(StdJob.EDU_DEGREE, stdJob.getEduDegree())
				.set(StdJob.INDE_YEARS, stdJob.getIndeYears()).set(StdJob.MEMO2, stdJob.getMemo2())
				.set(StdJob.MODE_NAME, stdJob.getModeName()).set(StdJob.MODE_TIME, DateUtil.longDateTime())
				.set(StdJob.OTHERLIST, stdJob.getOtherList());
		mongoTemplate.updateFirst(query, update, StdJob.class);
		return stdJob;
	}

	// 删除
	@Override
	public int delete(List<String> list) {
		Query query = new Query();
		// Criteria：条件
		Criteria criteria = Criteria.where(StdJob.UUID).in(list);
		query.addCriteria(criteria);
		Update update = new Update();
		update.set(StdJob.IS_DEL, DelEnums.IsDel_NOT_EXIST.getIsDel());
		mongoTemplate.updateMulti(query, update, StdJob.class);
		return list.size();
	}

	// 查询
	@Override
	public ResList<StdJob> select(ReqQuery<StdJobFilter> filter) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		StdJobFilter stdJobFilter = filter.getObject();
		// 根据公司uuid模糊查询
		if (stdJobFilter.getCorp_uuid() != null && !"".equals(stdJobFilter.getCorp_uuid())) {
			criteria = Criteria.where(StdJob.CORP_UUID).regex(stdJobFilter.getCorp_uuid());
			query.addCriteria(criteria);
		}
		// 根据职位代码模糊查询
		if (stdJobFilter.getJob_code() != null && !"".equals(stdJobFilter.getJob_code())) {
			criteria = Criteria.where(StdJob.JOB_CODE).regex(stdJobFilter.getJob_code());
			query.addCriteria(criteria);
		}
		// 根据岗位类别精确查询
		if (stdJobFilter.getCategory() != null && !"".equals(stdJobFilter.getCategory())) {
			criteria = Criteria.where(StdJob.CATEGORY).is(stdJobFilter.getCategory());
			query.addCriteria(criteria);
		}
		// 查询未被删除的
		criteria = Criteria.where(StdJob.IS_DEL).is(DelEnums.ISDel_EXIST.getIsDel());
		query.addCriteria(criteria);
		// 按照创建时间降序排序
		query.with(new Sort(new Sort.Order(Sort.Direction.DESC, StdJob.REG_TIME)));

		ResList<StdJob> resList = new ResList<>();
		if (filter.getPageRow() > 0) {
			//分页
			long totalCount = mongoTemplate.count(query, StdJob.class);
			Pagination<StdJob> page = new Pagination<>(filter.getStartPage(), filter.getPageRow(), totalCount);
			query.skip(page.getFirstResult());
			query.limit(filter.getPageRow());
			
			List<StdJob> list = mongoTemplate.find(query, StdJob.class);
			resList.setList(list);
			resList.setStartPage(page.getPageNo());
			resList.setPageRow(page.getPageSize());
			resList.setTotalRow(page.getTotalCount());
			return resList;
		} else {
			List<StdJob> list = mongoTemplate.find(query, StdJob.class);
			resList.setList(list);
		}
		return resList;
	}

}
