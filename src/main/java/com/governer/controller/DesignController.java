package com.governer.controller;

import com.governer.common.BaseResponse;
import com.governer.domain.vo.request.BatchDesignTaskInsertRequestVO;
import com.governer.domain.vo.request.FlowEditUpdateRequestVO;
import com.governer.domain.vo.response.FlowEditQueryResponseVO;
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
    @ApiOperation(value = "设计-主页面新增", notes = "设计-主页面新增接口")
    public BaseResponse insert(@RequestBody BatchDesignTaskInsertRequestVO requestVO) {
        log.info("设计-主页面新增接口入参：{}", requestVO.toString());
        try {
            return designService.insert(requestVO);
        }catch (Exception e) {
            log.error("设计-主页面新增接口失败: ", e);
            return BaseResponse.fail(e.toString());
        }
    }

    @GetMapping("task/flowEdit")
    @ApiOperation(value = "设计-主页面-流程任务查询", notes = "设计-主页面-流程任务查询接口")
    public BaseResponse<FlowEditQueryResponseVO> flowEditQuery(@RequestParam String task_name) {
        log.info("设计-主页面-流程任务查询接口入参：task_name={}", task_name);
        try {
            return designService.flowEditQuery(task_name);
        }catch (Exception e) {
            log.error("设计-主页面新增接口失败: ", e);
            return BaseResponse.fail(e.toString());
        }
    }

    @PostMapping("task/flowEdit")
    @ApiOperation(value = "设计-主页面-流程任务修改", notes = "设计-主页面-流程任务修改接口")
    public BaseResponse<Boolean> flowEdit(@RequestBody FlowEditUpdateRequestVO requestVO) {
        log.info("设计-主页面-流程任务修改接口入参：FlowEditUpdateRequestVO={}", requestVO);
        try {
            return designService.flowEdit(requestVO);
        }catch (Exception e) {
            log.error("设计-主页面接口失败: ", e);
            return BaseResponse.fail(e.toString());
        }
    }
}
