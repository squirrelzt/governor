package com.governer.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页类")
public class PageParam {
    @ApiModelProperty("页码")
    private Integer pageNumber;

    @ApiModelProperty("页数")
    private Integer pageSize;

    @ApiModelProperty("总条数")
    private Long total;

    @ApiModelProperty("排序字段")
    private String sortName;

    @ApiModelProperty("排序规则：ASC-升序;DESC-降序")
    private String sortOrder;
}
