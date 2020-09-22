package com.governer.mapper;

import com.governer.domain.po.ConfigPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ConfigPOMapperTest {

    @Autowired
    ConfigPOMapper configPOMapper;

    @Test
    public void batchUpdateConfig() {
        List<ConfigPO> list = new ArrayList<>(2);

        ConfigPO po1 = new ConfigPO();
        po1.setId(1L);
        po1.setEnabled(Short.parseShort("1"));
        po1.setDescription("批量启动1");
        po1.setLastModStamp(LocalDateTime.now());
        list.add(po1);

        ConfigPO po2 = new ConfigPO();
        po2.setId(2L);
        po2.setEnabled(Short.parseShort("1"));
        po2.setDescription("批量启动2");
        po2.setLastModStamp(LocalDateTime.now());
        list.add(po2);

        int count = configPOMapper.batchUpdateConfig(list);
        System.out.println(count);
    }
}
