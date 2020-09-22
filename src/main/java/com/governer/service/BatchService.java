package com.governer.service;

import com.governer.common.BaseResponse;
import com.governer.domain.vo.request.ConfigRequestVO;
import com.governer.domain.vo.response.ConfigResponseVO;

import java.util.List;

public interface BatchService {
    BaseResponse<List<ConfigResponseVO>> config(String appName, String name);

    BaseResponse<Boolean> save(ConfigRequestVO requestVO);

    BaseResponse<Boolean> start(String appName);

    BaseResponse<Boolean> stop(String appName);
}
