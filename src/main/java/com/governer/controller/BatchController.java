package com.governer.controller;

import com.governer.common.BaseResponse;
import com.governer.domain.vo.request.ConfigRequestVO;
import com.governer.domain.vo.response.ConfigResponseVO;
import com.governer.service.BatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("batch")
@Api(value = "批量接口", produces = "批量接口服务")
public class BatchController {

    @Autowired
    BatchService batchService;

    @GetMapping("config")
    @ApiOperation(value = "定时-查询", notes = "定时-查询接口")
    public BaseResponse<List<ConfigResponseVO>> config(@RequestParam(required = false) @ApiParam("应用名称") String app_name,
                                                       @RequestParam(required = false) @ApiParam("作业名称") String name) {
        return batchService.config(app_name, name);
    }

    @PostMapping("config/save")
    @ApiOperation(value = "定时-保存", notes = "定时-保存接口")
    public BaseResponse<Boolean> save(@RequestBody ConfigRequestVO requestVO) {
        try {
            return batchService.save(requestVO);
        }catch (Exception e) {
            log.error("定时-保存接口失败: ", e.getMessage());
            return BaseResponse.fail(e.getMessage());
        }

    }
    @PostMapping("config/start")
    @ApiOperation(value = "定时-启用", notes = "定时-启用接口")
    public BaseResponse<Boolean> start(@RequestParam @ApiParam("应用名称") String app_name) {
        return batchService.start(app_name);
    }

    @PostMapping("config/stop")
    @ApiOperation(value = "定时-停用", notes = "定时-停用接口")
    public BaseResponse<Boolean> stop(@RequestParam @ApiParam("应用名称") String app_name) {
        return batchService.stop(app_name);
    }
}
