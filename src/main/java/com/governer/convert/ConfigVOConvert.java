package com.governer.convert;

import com.governer.domain.po.ConfigPO;
import com.governer.domain.vo.request.ConfigRequestVO;
import com.governer.domain.vo.response.ConfigResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ConfigVOConvert {

    ConfigVOConvert INSTANCE = Mappers.getMapper(ConfigVOConvert.class);

    @Mappings({
        @Mapping(source = "appName", target = "app_name"),
        @Mapping(source = "lastModStamp", target = "last_mod_stamp", dateFormat="yyyy-MM-dd hh:mm:ss")
    })
    ConfigResponseVO convertConfigPO(ConfigPO configPO);

    List<ConfigResponseVO> convertConfigPOList(List<ConfigPO> list);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "app_name", target = "appName")
    })
    ConfigPO convertConfigRequestVO(ConfigRequestVO requestVO);

    List<ConfigPO> convertConfigRequestVOList(List<ConfigRequestVO> requestVOList);
}
