package com.governer.service;

import com.governer.common.BaseResponse;
import com.governer.domain.vo.request.BatchDesignTaskInsertRequestVO;
import com.governer.domain.vo.request.FlowEditUpdateRequestVO;
import com.governer.domain.vo.response.FlowEditQueryResponseVO;
import com.governer.domain.vo.response.TaskTemplateVO;

import java.util.List;

public interface DesignService {
    BaseResponse<List<TaskTemplateVO>> task(String taskName, String taskType, String description);

    BaseResponse<Boolean> insert(BatchDesignTaskInsertRequestVO requestVO) throws Exception;

    BaseResponse<FlowEditQueryResponseVO> flowEditQuery(String taskName);

    BaseResponse<Boolean> flowEdit(FlowEditUpdateRequestVO requestVO);
}
