package com.lz.spring.boot.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lz.spring.boot.mongo.model.StdJob;
import com.lz.spring.boot.mongo.param.StdJobFilter;
import com.lz.spring.boot.mongo.service.StdJobService;

import cn.lz.cloud.common.service.ClazzNote;
import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
import cn.lz.cloud.common.service.ResObject;
import cn.lz.cloud.common.service.ServiceNote;
import cn.lz.cloud.common.service.ServiceNote.AUTH;

/**
 * 岗位信息Controller类
 * 
 * @author YangMing
 * @date 2017年11月20日
 */
@RestController
@RequestMapping("/stujob")
@ClazzNote(desc = "岗位信息", resource = "stdJob", modName = "岗位管理")
public class StdJobController {

	@Autowired
	private StdJobService stdJobService;

	@RequestMapping("/save")
	@ServiceNote(desc = "新增岗位信息", auth = AUTH.CHECK)
	public ResObject<StdJob> save(@RequestBody ReqObject<StdJob> data) {
		try {
			StdJob stdJob = stdJobService.insert(data);
			return new ResObject<StdJob>(data, stdJob);
		} catch (Exception e) {
			return new ResObject<StdJob>(data, e);
		}
	}

	@RequestMapping("/update")
	@ServiceNote(desc = "修改岗位信息", auth = AUTH.CHECK)
	public ResObject<StdJob> update(@RequestBody ReqObject<StdJob> data) {
		try {
			StdJob stdJob = stdJobService.update(data);
			return new ResObject<StdJob>(data, stdJob);
		} catch (Exception e) {
			return new ResObject<StdJob>(data, e);
		}
	}

	@RequestMapping("/delete")
	@ServiceNote(desc = "批量删除岗位信息", auth = AUTH.CHECK)
	public ResObject<Integer> delete(@RequestBody ReqObject<List<String>> data) {
		try {
			Integer row = stdJobService.delete(data);
			return new ResObject<Integer>(data, row);
		} catch (Exception e) {
			return new ResObject<Integer>(data, e);
		}
	}

	// 查询条件：corp_uuid（模糊查询）,job_code（模糊查询）， ==category
	@RequestMapping("/select")
	@ServiceNote(desc = "查询岗位信息列表", auth = AUTH.CHECK)
	public ResObject<ResList<StdJob>> selete(@RequestBody ReqObject<ReqQuery<StdJobFilter>> data) {
		try {
			ResList<StdJob> list = stdJobService.select(data);
			return new ResObject<ResList<StdJob>>(data, list);
		} catch (Exception e) {
			return new ResObject<ResList<StdJob>>(data, e);
		}
	}
}
