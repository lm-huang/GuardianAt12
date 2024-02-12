package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: sky-take-out
 * @description:
 * @author: Liming Huang
 * @create-time: 2024-01-11 21:40
 **/
@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建redis模版对象");
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置redis的序列化器，可以不设置，使用redis默认的序列化器，则redis里的key样式类似于: \xac\xed\x00\x05t\x00\x08name
        //设置后仅有name
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
