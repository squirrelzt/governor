package com.governer.controller;

import com.governer.common.BaseResponse;
import com.governer.domain.vo.request.BatchDesignTaskInsertRequestVO;
import com.governer.domain.vo.response.TaskTemplateVO;
import com.governer.service.DesignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("batch/design")
@Api(value = "批量接口", produces = "批量接口服务")
public class DesignController {

    @Autowired
    DesignService designService;

    @GetMapping("task")
    @ApiOperation(value = "设计-查询", notes = "设计-查询接口")
    public BaseResponse<List<TaskTemplateVO>> task(@RequestParam(value = "task_name", required = false) @ApiParam("任务名称")String task_name,
                                                   @RequestParam(value = "task_type", required = false) @ApiParam("任务类型")String task_type,
                                                   @RequestParam(value = "description", required = false) @ApiParam("任务描述")String description) {
        log.info("设计-查询接口入参: task_name={},task_type={},description={}", task_name, task_type, description);
        try {
            return designService.task(task_name, task_type, description);
        }catch (Exception e) {
            log.error("设计-查询接口失败: ", e);
            return BaseResponse.fail(e.toString());
        }
    }

    @PostMapping("task")
    public BaseResponse insert(@RequestBody BatchDesignTaskInsertRequestVO requestVO) {
        log.info("设计-主页面新增接口入参：{}", requestVO.toString());
        try {
            return designService.insert(requestVO);
        }catch (Exception e) {
            log.error("设计-主页面新增接口失败: ", e);
            return BaseResponse.fail(e.toString());
        }
    }
}
