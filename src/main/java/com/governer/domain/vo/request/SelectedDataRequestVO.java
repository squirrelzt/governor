package com.governer.domain.vo.request;

import lombok.Data;

import java.util.List;

@Data
public class SelectedDataRequestVO {
    private List<ConfigRequestVO> selectedData;
}
