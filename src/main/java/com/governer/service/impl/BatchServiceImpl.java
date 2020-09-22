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

import java.time.LocalDateTime;
import java.util.Date;
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
        long id = configPO.getId();
        configPO.setLastModStamp(LocalDateTime.now());
        int count = configPOMapper.insertSelective(configPO);
        if (1 == count) {
            return BaseResponse.ok(Boolean.TRUE);
        } else {
            return BaseResponse.fail("新建失败");
        }
    }

    @Override
    public BaseResponse<Boolean> start(List<ConfigRequestVO> requestVOList) {
        List<ConfigPO> list = ConfigVOConvert.INSTANCE.convertConfigRequestVOList(requestVOList);
        return setEnabled(list, "1");
    }

    @Override
    public BaseResponse<Boolean> stop(List<ConfigRequestVO> requestVOList) {
        List<ConfigPO> list = ConfigVOConvert.INSTANCE.convertConfigRequestVOList(requestVOList);
        return setEnabled(list, "0");
    }

    private BaseResponse<Boolean> setEnabled(List<ConfigPO> list, String enabled) {
        for (ConfigPO po: list) {
            po.setEnabled(Short.parseShort(enabled));
        }
        int count = configPOMapper.batchUpdateConfig(list);
        if (1 == count) {
            return BaseResponse.ok(Boolean.TRUE);
        } else {
            if ("1".equals(enabled)) {
                return BaseResponse.fail("定时-启动失败");
            } else {
                return BaseResponse.fail("定时-停用失败");
            }
        }
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
