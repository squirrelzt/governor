package com.governer.common;

import com.governer.enums.ResponseCodeEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("返回值类")
public class BaseResponse<T> extends PageParam {
    @ApiModelProperty("200 的状态为成功,否则为失败")
    private Integer code;

    @ApiModelProperty("返回的数据(通用格式为一个对象,分页格式data为一个数组)")
    private T data;

    @ApiModelProperty("返回的提示信息")
    private String message;

    @ApiModelProperty("数据总量")
    private PageParam pageParam;

    public static <T> BaseResponse<T> ok(T t) {
        return new BaseResponse<T>(ResponseCodeEnums.SUCCESS.getCode(), t, ResponseCodeEnums.SUCCESS.getMessage(), new PageParam());
    }

    public static <T> BaseResponse<T> fail(String msg) {
        return new BaseResponse<T>(ResponseCodeEnums.FAIL.getCode(), null, msg, new PageParam());
    }
}
