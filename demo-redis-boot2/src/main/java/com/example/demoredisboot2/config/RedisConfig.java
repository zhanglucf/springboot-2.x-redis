package com.example.demoredisboot2.config;

import com.example.demoredisboot2.FastJson2JsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;

    private static final FastJson2JsonRedisSerializer fastJson2JsonSerializer;

    private static final Jackson2JsonRedisSerializer<Object> jacksonSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);

    private static final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

    private static final GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer<Object>(Object.class);

    static {
        fastJson2JsonSerializer = new FastJson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        fastJson2JsonSerializer.setObjectMapper(mapper);
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate1() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory1());
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(stringRedisSerializer);
        template.setHashValueSerializer(stringRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate2() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory2());
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(stringRedisSerializer);
        template.setHashValueSerializer(fastJson2JsonSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate3() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory3());
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(stringRedisSerializer);
        template.setHashValueSerializer(jacksonSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate4() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory4());
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(fastJson2JsonSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(fastJson2JsonSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate5() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory5());
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(genericToStringSerializer);
        template.setHashValueSerializer(genericToStringSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate6() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory6());
        template.afterPropertiesSet();
        return template;
    }

    private RedisConnectionFactory redisConnectionFactory() {
        JedisClientConfiguration clientConfig = initJedisClient();
        RedisStandaloneConfiguration redisConfig = initRedisConfig(0);
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

    private RedisConnectionFactory redisConnectionFactory1() {
        JedisClientConfiguration clientConfig = initJedisClient();
        RedisStandaloneConfiguration redisConfig = initRedisConfig(1);
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

    private RedisConnectionFactory redisConnectionFactory2() {
        JedisClientConfiguration clientConfig = initJedisClient();
        RedisStandaloneConfiguration redisConfig = initRedisConfig(2);
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

    private RedisConnectionFactory redisConnectionFactory3() {
        JedisClientConfiguration clientConfig = initJedisClient();
        RedisStandaloneConfiguration redisConfig = initRedisConfig(3);
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

    private RedisConnectionFactory redisConnectionFactory4() {
        JedisClientConfiguration clientConfig = initJedisClient();
        RedisStandaloneConfiguration redisConfig = initRedisConfig(4);
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

    private RedisConnectionFactory redisConnectionFactory5() {
        JedisClientConfiguration clientConfig = initJedisClient();
        RedisStandaloneConfiguration redisConfig = initRedisConfig(5);
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

    private RedisConnectionFactory redisConnectionFactory6() {
        JedisClientConfiguration clientConfig = initJedisClient();
        RedisStandaloneConfiguration redisConfig = initRedisConfig(6);
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

    private RedisStandaloneConfiguration initRedisConfig(int dbIndex) {
        // 单点redis
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        // 哨兵redis
        // RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
        // 集群redis
        // RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
        redisConfig.setHostName(redisHost);
        if (!StringUtils.isEmpty(redisPassword)) {
            redisConfig.setPassword(RedisPassword.of(redisPassword));
        }
        redisConfig.setPort(redisPort);
        redisConfig.setDatabase(dbIndex);
        return redisConfig;
    }

    private JedisClientConfiguration initJedisClient() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(1);
        poolConfig.setMaxWaitMillis(3000);
        poolConfig.setMinIdle(1);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(false);
        poolConfig.setTestWhileIdle(true);
        return JedisClientConfiguration.builder()
                .usePooling().poolConfig(poolConfig).and().readTimeout(Duration.ofMillis(3000)).build();
    }

}
