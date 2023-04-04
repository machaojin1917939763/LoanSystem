package com.ruoyi.web.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ruoyi.*.mapper")
public class MyBatisConfigScan {
}
