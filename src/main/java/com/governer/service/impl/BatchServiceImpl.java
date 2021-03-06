package com.governer.service.impl;

import com.governer.common.BaseResponse;
import com.governer.convert.ConfigVOConvert;
import com.governer.domain.po.ConfigPO;
import com.governer.domain.po.ConfigPOExample;
import com.governer.domain.vo.request.ConfigRequestVO;
import com.governer.domain.vo.response.ConfigResponseVO;
import com.governer.mapper.ConfigPOMapper;
import com.governer.service.BatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    ConfigPOMapper configPOMapper;

    @Override
    public BaseResponse<List<ConfigResponseVO>> config(String appName, String name) {
        ConfigPOExample example = new ConfigPOExample();
        ConfigPOExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(appName)) {
            criteria.andAppNameEqualTo(appName);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameEqualTo(name);
        }
        List<ConfigPO> list = configPOMapper.selectByExample(example);
        List<ConfigResponseVO> responseVOList = ConfigVOConvert.INSTANCE.convertConfigPOList(list);
        return BaseResponse.ok(responseVOList);
    }

    @Override
    public BaseResponse<Boolean> save(ConfigRequestVO requestVO) {
        ConfigPO configPO = ConfigVOConvert.INSTANCE.convertConfigRequestVO(requestVO);
        int count = configPOMapper.insertSelective(configPO);
        if (1 == count) {
            return BaseResponse.ok(Boolean.TRUE);
        } else {
            return BaseResponse.fail("新建失败");
        }
    }

    @Override
    public BaseResponse<Boolean> start(String appName) {
        return setEnabled(appName, "1");
    }

    @Override
    public BaseResponse<Boolean> stop(String appName) {
        return setEnabled(appName, "0");
    }

    private BaseResponse<Boolean> setEnabled(String appName, String enabled) {
        ConfigPOExample example = new ConfigPOExample();
        ConfigPOExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(appName)) {
            criteria.andAppNameEqualTo(appName);
        }
        ConfigPO record = new ConfigPO();
        record.setAppName(appName);
        record.setEnabled(Short.valueOf(enabled));
        int count = configPOMapper.updateByExampleSelective(record, example);
        if (1 == count) {
            return BaseResponse.ok(Boolean.TRUE);
        } else {
            return BaseResponse.fail("新增失败");
        }
    }
}
