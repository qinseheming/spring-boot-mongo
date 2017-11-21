package com.lz.spring.boot.mongo.model;

import cn.lz.cloud.common.service.FieldNote;
import cn.lz.cloud.common.service.PojoNote;
/**
 * Other实体类
 * @author YangMing
 * @date 2017年11月20日
 */
@PojoNote(desc = "其他信息")
public class Other {
	
	@FieldNote(desc = "地区", length = 24, notNull = false)
	private String jobLocal;
	@FieldNote(desc = "工资范围", length = 24, notNull = false)
	private String jobSalary;
	@FieldNote(desc = "工作性质：全职、兼职、实习", length = 24, notNull = false)
	private String nature;
	public String getJobLocal() {
		return jobLocal;
	}
	public void setJobLocal(String jobLocal) {
		this.jobLocal = jobLocal;
	}
	public String getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	@Override
	public String toString() {
		return "Other [jobLocal=" + jobLocal + ", jobSalary=" + jobSalary + ", nature=" + nature + "]";
	}

	
}
