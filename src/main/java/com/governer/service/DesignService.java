package com.governer.service;

import com.governer.common.BaseResponse;
import com.governer.domain.vo.request.BatchDesignTaskInsertRequestVO;
import com.governer.domain.vo.response.TaskTemplateVO;

import java.util.List;

public interface DesignService {
    BaseResponse<List<TaskTemplateVO>> task(String taskName, String taskType, String description);

    BaseResponse<Boolean> insert(BatchDesignTaskInsertRequestVO requestVO);
}
