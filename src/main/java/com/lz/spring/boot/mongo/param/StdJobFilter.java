package com.lz.spring.boot.mongo.param;

import cn.lz.cloud.common.service.FieldNote;
import cn.lz.cloud.common.service.PojoNote;

/**
 * 查询接口：查询条件：corp_uuid（模糊查询）,job_code（模糊查询）， ==category
 * 
 * @author YangMing
 * @date 2017年11月20日
 */
@PojoNote(desc = "查询接口")
public class StdJobFilter {

	@FieldNote(desc = "公司uuid", length = 24, notNull = false)
	private String corp_uuid;
	@FieldNote(desc = "岗位代码", length = 24, notNull = false)
	private String job_code;
	@FieldNote(desc = "岗位类别", length = 24, notNull = false)
	private String category;

	public String getCorp_uuid() {
		return corp_uuid;
	}

	public void setCorp_uuid(String corp_uuid) {
		this.corp_uuid = corp_uuid;
	}

	public String getJob_code() {
		return job_code;
	}

	public void setJob_code(String job_code) {
		this.job_code = job_code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "StdJobFilter [corp_uuid=" + corp_uuid + ", job_code=" + job_code + ", category=" + category + "]";
	}

}
