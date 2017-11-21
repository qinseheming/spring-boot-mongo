package com.lz.spring.boot.mongo.model;

import java.util.List;

import cn.lz.cloud.common.service.FieldNote;
import cn.lz.cloud.common.service.PojoNote;

/**
 * stu_job实体类
 * 
 * @author YangMing
 * @date 2017年11月20日
 */
@PojoNote(desc = "岗位信息")
public class StdJob {

	public static final String UUID = "uuid";
	public static final String CORP_UUID = "corpUuid";
	public static final String JOB_CODE = "jobCode";
	public static final String CATEGORY = "category";
	public static final String JOB_DESC = "jobDesc";
	public static final String JOB_REQUIRE = "jobRequire";
	public static final String JOB_LEVEL = "jobLevel";
	public static final String EDU_DEGREE = "eduDegree";
	public static final String INDE_YEARS = "indeYears";
	public static final String MEMO2 = "memo2";
	public static final String REG_NAME = "regName";
	public static final String REG_TIME = "regTime";
	public static final String MODE_NAME = "modeName";
	public static final String MODE_TIME = "modeTime";
	public static final String IS_DEL = "isDel";
	public static final String OTHERLIST = "otherList";

	@FieldNote(desc = "uuid", length = 24, notNull = true)
	private String uuid;
	@FieldNote(desc = "公司uuid", length = 24, notNull = true)
	private String corpUuid;
	@FieldNote(desc = "岗位代码", length = 24)
	private String jobCode;
	@FieldNote(desc = "岗位类别", length = 24)
	private String category;
	@FieldNote(desc = "岗位说明", length = 1024)
	private String jobDesc;
	@FieldNote(desc = "岗位要求", length = 1024)
	private String jobRequire;
	@FieldNote(desc = "岗位级别", length = 24)
	private String jobLevel;
	@FieldNote(desc = "最低学历", length = 24)
	private String eduDegree;
	@FieldNote(desc = "工作经验", length = 24)
	private String indeYears;

	@FieldNote(desc = "说明", length = 24)
	private String memo2;
	@FieldNote(desc = "登记人", length = 24)
	private String regName;
	@FieldNote(desc = "登记时间", length = 24)
	private String regTime;
	@FieldNote(desc = "修改人", length = 24)
	private String modeName;
	@FieldNote(desc = "修改时间", length = 24)
	private String modeTime;
	@FieldNote(desc = "是否删除：0：已删除，1：未删除", length = 24)
	private String isDel;

	private List<Other> otherList;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCorpUuid() {
		return corpUuid;
	}

	public void setCorpUuid(String corpUuid) {
		this.corpUuid = corpUuid;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobRequire() {
		return jobRequire;
	}

	public void setJobRequire(String jobRequire) {
		this.jobRequire = jobRequire;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getEduDegree() {
		return eduDegree;
	}

	public void setEduDegree(String eduDegree) {
		this.eduDegree = eduDegree;
	}

	public String getIndeYears() {
		return indeYears;
	}

	public void setIndeYears(String indeYears) {
		this.indeYears = indeYears;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public String getModeTime() {
		return modeTime;
	}

	public void setModeTime(String modeTime) {
		this.modeTime = modeTime;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public List<Other> getOtherList() {
		return otherList;
	}

	public void setOtherList(List<Other> otherList) {
		this.otherList = otherList;
	}

	@Override
	public String toString() {
		return "StdJob [uuid=" + uuid + ", corpUuid=" + corpUuid + ", jobCode=" + jobCode + ", category=" + category
				+ ", jobDesc=" + jobDesc + ", jobRequire=" + jobRequire + ", jobLevel=" + jobLevel + ", eduDegree="
				+ eduDegree + ", indeYears=" + indeYears + ", memo2=" + memo2 + ", regName=" + regName + ", regTime="
				+ regTime + ", modeName=" + modeName + ", modeTime=" + modeTime + ", isDel=" + isDel + ", otherList="
				+ otherList + "]";
	}

}
