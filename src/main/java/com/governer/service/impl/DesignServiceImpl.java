package com.governer.service.impl;

import com.governer.common.BaseResponse;
import com.governer.convert.TaskTemplateVOConvert;
import com.governer.convert.batch.design.BatchDesignTaskInsertConvert;
import com.governer.domain.po.*;
import com.governer.domain.vo.request.BatchDesignTaskInsertRequestVO;
import com.governer.domain.vo.response.TaskTemplateVO;
import com.governer.mapper.BatchJobTemplatePOMapper;
import com.governer.mapper.FlowTemplateDetailPOMapper;
import com.governer.mapper.SimpleTaskTemplatePOMapper;
import com.governer.mapper.TaskTemplatePOMapper;
import com.governer.service.DesignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class DesignServiceImpl implements DesignService {

    @Autowired
    TaskTemplatePOMapper taskTemplatePOMapper;
    @Autowired
    SimpleTaskTemplatePOMapper simpleTaskTemplatePOMapper;
    @Autowired
    BatchJobTemplatePOMapper batchJobTemplatePOMapper;
    @Autowired
    FlowTemplateDetailPOMapper flowTemplateDetailPOMapper;

    @Override
    public BaseResponse<List<TaskTemplateVO>> task(String taskName, String taskType, String description) {
        TaskTemplatePOExample example = new TaskTemplatePOExample();
        TaskTemplatePOExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(taskName)) {
            criteria.andTaskNameEqualTo(taskName);
        }
        if (!StringUtils.isEmpty(taskType)) {
            criteria.andTaskTypeEqualTo(taskType);
        }
        if (!StringUtils.isEmpty(description)) {
            criteria.andDescriptionLike("%" + description + "%");
        }
        List<TaskTemplatePO> poList = taskTemplatePOMapper.selectByExample(example);
        List<TaskTemplateVO> list = TaskTemplateVOConvert.INSTANCE.convertTaskTemplatePOList(poList);
        return BaseResponse.ok(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse<Boolean> insert(BatchDesignTaskInsertRequestVO requestVO) throws Exception{
        TaskTemplatePO taskTemplatePO = BatchDesignTaskInsertConvert.INSTANCE.convertInsertRequestVO2TaskTemplatePO(requestVO);
        int count = taskTemplatePOMapper.insert(taskTemplatePO);
        String taskType = requestVO.getTask_type();
        if ("SIMPLE".equals(taskType)) {
            SimpleTaskTemplatePO simpleTaskTemplatePO = BatchDesignTaskInsertConvert.INSTANCE.convertInsertRequestVO2SimpleTaskTemplatePO(requestVO);
            int subCount1 = simpleTaskTemplatePOMapper.insert(simpleTaskTemplatePO);

            BatchJobTemplatePO batchJobTemplatePO = BatchDesignTaskInsertConvert.INSTANCE.convertInsertRequestVO2BatchJobTemplatePO(requestVO);
            int subCount2 = batchJobTemplatePOMapper.insert(batchJobTemplatePO);
            if (1 == count && 1 == subCount1 && 1 == subCount2) {
                return BaseResponse.ok(Boolean.TRUE);
            } else {
                throw new Exception("设计-新增主页面失败");
            }
        } else if ("FLOW".equals(taskType)) {
            FlowTemplateDetailPO flowTemplateDetailPO = BatchDesignTaskInsertConvert.INSTANCE.convertInsertRequestVO2FlowTemplateDetailPO(requestVO);
            int subCount1 = flowTemplateDetailPOMapper.insert(flowTemplateDetailPO);
            if (1 == count && 1 == subCount1) {
                return BaseResponse.ok(Boolean.TRUE);
            } else {
                throw new Exception("设计-新增主页面失败");
            }
        }
        return BaseResponse.fail("设计-新增主页面失败");
    }
}
