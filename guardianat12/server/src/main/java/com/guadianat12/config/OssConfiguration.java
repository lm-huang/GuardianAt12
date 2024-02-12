package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: sky-take-out
 * @description:
 * @author: Liming Huang
 * @create-time: 2023-10-21 23:16
 **/

@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean //只有不存在这个bean，才会创建，配置类常用，与@bean一起用
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties){//aliossproperties上有component注解
        log.info("Initializing the utility tool for Alibaba OSS :{}", aliOssProperties);
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),
                aliOssProperties.getBucketName());
    }
}
