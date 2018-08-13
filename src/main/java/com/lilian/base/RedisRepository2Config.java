package com.lilian.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * llld-parent
 *
 * @Author 孙龙
 * @Date 2018/8/2
 */
@Configuration
@EnableCaching
public class RedisRepository2Config extends RedisConfig {


    @Value("${spring.redis.database}")
    private int dbIndex;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Bean
    public RedisConnectionFactory defaultRedisConnectionFactory() {
        return createJedisConnectionFactory(dbIndex, host, port, password, timeout);
    }

    @Bean(name = "defaultRedisTemplate")
    public RedisTemplate defaultRedisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(defaultRedisConnectionFactory());
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }

}
