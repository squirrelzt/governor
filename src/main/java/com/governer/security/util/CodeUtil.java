package com.governer.security.util;

public class CodeUtil {

	public static final String INFO_200 = "200";// 操作成功

	public static final String WARN_403 = "403";// 未授权

	public static final String ERROR_410 = "410";// 账户不存在
	public static final String ERROR_411 = "411";// 密码错误
	public static final String ERROR_412 = "412";// 原始密码错误
	public static final String ERROR_413 = "413";// token 失效

	public static final String USER_ACCOUNT_EXPIRED = "USER_ACCOUNT_EXPIRED";
	public static final String USER_ACCOUNT_LOCKED = "USER_ACCOUNT_LOCKED";
	public static final String USER_ACCOUNT_DISABLED = "USER_ACCOUNT_DISABLED";
	public static final String USER_ACCOUNT_NOT_FOUND = "USER_ACCOUNT_NOT_FOUND";
	public static final String USER_CREDENTIAL_EXPIRED = "USER_CREDENTIAL_EXPIRED";
	public static final String USER_CREDENTIAL_ERROR = "USER_CREDENTIAL_ERROR";
	public static final String NON_TOKEN_HEADER = "NON_TOKEN_HEADER";

	// dict
	public static final String ERROR_DICT_EXIST = "DICT_EXIST";// 数据字典已存在

	// organization
	public static final String ERROR_ORG_EXIST = "ORG_EXIST";// 机构信息已存在
	public static final String ERROR_ORG_HAS_CHILD = "ORG_HAS_CHILD";// 机构信息存在子节点

	// postion
	public static final String ERROR_POSTION_EXIST = "POSTION_EXIST";// 岗位信息已存在
	public static final String ERROR_POSTION_HAS_CHILD = "POSTION_HAS_CHILD";// 岗位信息存在子节点

	// employee
	public static final String ERROR_EMPLOYEE_EXIST = "EMPLOYEE_EXIST";// 员工信息已存在

	// user
	public static final String ERROR_USER_EXIST = "USER_EXIST";// 人员信息已存在
	public static final String ERROR_USER_PASSWORD_ERROR = "USER_PASSWORD_ERROR";// 密码错误

	// role
	public static final String ERROR_ROLE_EXIST = "ROLE_EXIST";// 角色信息已存在

	// resource
	public static final String ERROR_RESOU_EXIST = "RESOU_EXIST";// 资源信息已存在

	// application
	public static final String ERROR_APP_EXIST = "APP_EXIST";// 应用信息已存在

	// homepage
	public static final String ERROR_HOMEPAGE_EXIST = "HOMEPAGE_EXIST";// 首页信息已存在
}
