package com.governer.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.governer.common.BaseResponse;
import com.governer.common.PageParam;
import com.governer.domain.po.UserPO;
import com.governer.enums.ResponseCodeEnums;
import com.governer.security.core.userdetails.WebAuthenticationService;
import com.governer.security.core.userdetails.impl.WebUserDetails;
import com.governer.security.properties.WebProperties;
import com.governer.security.util.CodeUtil;
import com.governer.security.util.Constants;
import com.governer.security.util.JWTUtils;
import com.governer.security.util.SHAUtil;
import com.governer.service.security.UserService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private WebProperties webProperties;
	
	@Autowired
	private WebAuthenticationService authenticationService;

	@GetMapping("/page")
	@ApiOperation(value = "查询用户信息")
	public BaseResponse<Object> getUsers(@RequestParam Map<String, String> params) {
		PageParam pageParam = JSON.parseObject(JSON.toJSONString(params), PageParam.class);

		if (!StringUtils.isEmpty(params.get("userCode")))
			params.put("userCode", "%" + params.get("userCode") + "%");
		if (!StringUtils.isEmpty(params.get("userName")))
			params.put("userName", "%" + params.get("userName") + "%");

		PageInfo<UserPO> result = userService.pageQuery(params, pageParam);
		
		BaseResponse<Object> br = new BaseResponse<>();
		br.setCode(ResponseCodeEnums.SUCCESS.getCode());
		br.setData(result.getList());
		br.setPageNumber(result.getPageNum());
		br.setPageSize(result.getPageSize());
		br.setTotal(result.getTotal());
		
		return br;
	}

	@GetMapping
	@ApiOperation(value = "获取用户信息")
	public BaseResponse<UserPO> getUser(@RequestParam Map<String, String> params) {
		UserPO user = userService.selectOne(params);
		return BaseResponse.ok(user);
	}

	@PostMapping
	@ApiOperation(value = "新增用户")
	public BaseResponse<Object> insert(@RequestBody UserPO user) {
		userService.insertNotNull(user);
		return BaseResponse.ok(null);
	}

	@PutMapping
	@ApiOperation(value = "更新用户信息")
	public BaseResponse<Object> update(@RequestBody UserPO user) {
		userService.updateNotNull(user);
		return BaseResponse.ok(null);
	}

	@DeleteMapping
	@ApiOperation(value = "删除用户信息")
	public BaseResponse<Object> delete(@RequestBody UserPO user) {
		userService.deleteByPrimaryKey(user.getId());
		return BaseResponse.ok(null);
	}

	@DeleteMapping("/batch")
	@ApiOperation(value = "批量删除用户信息")
	public BaseResponse<Object> deleteBatch(@RequestBody Map<String, Object> params) {
		List<UserPO> list = JSON.parseArray(params.get("selectedData").toString(), UserPO.class);
		for (UserPO user : list) {
			userService.deleteByPrimaryKey(user.getId());
		}
		return BaseResponse.ok(null);
	}

	@GetMapping("/user-info")
	@ApiOperation(value = "获取用户信息")
	public BaseResponse<Object> getLoginInfo(HttpServletRequest request) {
		// 获取请求 token
		String token = request.getHeader(webProperties.getAuthorize().getTokenName());

		Map<String, String> params = new HashMap<>();
		params.put("userCode", JWTUtils.unsign(token, String.class));
		UserPO user = userService.selectOne(params);
		user.setUserPassword(null);
		return BaseResponse.ok(user);
	}

	@PutMapping("/update-pwd")
	@ApiOperation(value = "修改用户密码")
	public BaseResponse<Object> updateUserPassword(@RequestBody Map<String, String> params) {
		UserPO tmp = JSON.parseObject(JSON.toJSONString(params), UserPO.class);
		UserPO user = userService.selectOne(tmp);

		String pwd = params.get("password");
		if (null != user && user.getUserPassword().equals(pwd)) {
			// 设置新密码
			user.setUserPassword(params.get("newPassword"));
			userService.updateNotNull(user);
		} else {
			BaseResponse.fail(CodeUtil.ERROR_USER_PASSWORD_ERROR);
		}
		return BaseResponse.ok(null);
	}

	@GetMapping("/random-string")
	@ApiOperation(value = "获取用户信息携带随机密码")
	public BaseResponse<Object> getUserAndRandomPwd(@RequestParam Map<String, String> params) {
		UserPO temp = JSON.parseObject(JSON.toJSONString(params), UserPO.class);
		UserPO user = userService.selectOne(temp);

		// 生成随机密码
		int rp = (int) ((Math.random() * 9 + 1) * 100000);
		user.setUserPassword(String.valueOf(rp));
		return BaseResponse.ok(user);
	}

	@PutMapping("/reset-pwd")
	@ApiOperation(value = "重置用户密码")
	public BaseResponse<Object> resetUserPassword(@RequestBody UserPO user) {
		user.setUserPassword(SHAUtil.encrypt(user.getUserPassword()));
		userService.updateNotNull(user);
		return BaseResponse.ok(null);
	}

	@PutMapping("/lock")
	@ApiOperation(value = "用户锁定")
	public BaseResponse<Object> lockUser(@RequestBody UserPO user) {
		user.setStatus(Constants.USER_STATUS_EXPIRED);
		userService.updateNotNull(user);
		return BaseResponse.ok(null);
	}

	@PutMapping("/active")
	@ApiOperation(value = "用户激活")
	public BaseResponse<Object> activeUser(@RequestBody UserPO user) {
		user.setStatus(Constants.USER_STATUS_ACTIVE);
		userService.updateNotNull(user);
		return BaseResponse.ok(null);
	}

	@PutMapping(value = {"/theme", "/language"})
	@ApiOperation(value = "用户设置（主题、语言切换）")
	public BaseResponse<Object> updateByToken(@RequestBody UserPO user) {
		user.setStatus(Constants.USER_STATUS_ACTIVE);
		userService.updateNotNull(user);
		return BaseResponse.ok(null);
	}

	/**
	 * 刷新 token
	 * 
	 * @return
	 */
	@PostMapping("/refresh/token")
    @ApiOperation(value = "查询用户信息")
	public BaseResponse<Object> refreshToken(HttpServletRequest request) {
		String token = request.getHeader(webProperties.getAuthorize().getTokenName());
		String username = authenticationService.getUsernameByToken(token);
		WebUserDetails jwtUser = (WebUserDetails) authenticationService.loadUserByUsername(username);

		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("language", "zh_CN");
		userInfo.put("layout", jwtUser.getLayout());
		userInfo.put("theme", jwtUser.getTheme());
		userInfo.put("userCode", jwtUser.getUsername());
		userInfo.put("userName", jwtUser.getName());

		Map<String, Object> result = new HashMap<>();
		result.put(Constants.ACCESS_TOKEN, JWTUtils.sign(jwtUser.getUsername(), 1800));
		result.put(Constants.REFRESH_TOKEN, JWTUtils.sign(jwtUser.getUsername(), 3600));
		result.put(Constants.LOGIN_USER_INFO, userInfo);
		
		return BaseResponse.ok(result);
	}
}