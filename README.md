# spring-boot-mongo
公司的第二个练习项目
spring-boot集成mongodb练习
岗位信息：

std_job{
	uuid 			'uuid',
	corp_uuid 		'公司uuid',
	job_code 		'岗位代码',
	category 		'岗位类别',
	job_desc 		'岗位说明',
	job_require		'岗位要求',
	job_level 		'岗位级别',
	edu_degree		'最低学历',
	indu_years		'工作经验',

	memo2 			'说明',
	reg_name 		'登记人',
	reg_time 		'登记时间',
	mod_name 		'修改人',
	mod_time 		'修改时间'
	create_time             '创建时间'
        edite_time              '修改时间'
        is_del                  '是否删除（0：已删除，1：未删除）'

	other:[
		job_local 	'地区',
		job_salary 	'工资范围',
		job_nature 	'工作性质:全职、兼职、实习',
	]
}

接口开发：
1.新增：reg_name '登记人'不可重复
2.修改：reg_name '登记人'不可重复
3.查询接口：查询条件：corp_uuid（模糊查询）,job_code（模糊查询）， ==category
4.删除：逻辑删除（根据uuid批量删除）
