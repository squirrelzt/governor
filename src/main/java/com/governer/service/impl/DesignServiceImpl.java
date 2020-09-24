package com.governer.service.impl;

import com.governer.common.BaseResponse;
import com.governer.convert.TaskTemplateVOConvert;
import com.governer.domain.po.TaskTemplatePO;
import com.governer.domain.po.TaskTemplatePOExample;
import com.governer.domain.vo.response.TaskTemplateVO;
import com.governer.mapper.TaskTemplatePOMapper;
import com.governer.service.DesignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class DesignServiceImpl implements DesignService {

    @Autowired
    TaskTemplatePOMapper taskTemplatePOMapper;

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
}
