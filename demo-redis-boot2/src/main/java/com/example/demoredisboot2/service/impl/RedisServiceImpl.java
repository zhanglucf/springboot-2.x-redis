package com.example.demoredisboot2.service.impl;

import com.example.demoredisboot2.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save() {
//        ValueOperations opDB0 = selectDB(0).opsForValue();
//        opDB0.set("" + System.currentTimeMillis(), "hello1");
//        ValueOperations opDB1 = selectDB(1).opsForValue();
//        opDB1.set("" + System.currentTimeMillis(), "hello1");
//        ValueOperations opD = selectDB(3).opsForValue();
//        opD.set("" + System.currentTimeMillis(), "hello1");
//        ValueOperations op = selectDB(4).opsForValue();
//        op.set("" + System.currentTimeMillis(), "hello1");

//        ValueOperations op1 = redisTemplate9.opsForValue();
//        op1.set("redisTemplate9", "hello-9");
//        ValueOperations op = redisTemplate.opsForValue();
//        op.set("redisTemplate", "hello");
    }

    @Override
    public Object find() {
//        ValueOperations op1 = redisTemplate9.opsForValue();
//        Object redisTemplate9 = op1.get("redisTemplate9");
//        Object r = op1.get("redisTemplate");
//        ValueOperations op = redisTemplate.opsForValue();
//        Object redisTemplate = op.get("redisTemplate9");
//        Object redi = op.get("redisTemplate");
        return null;
    }


}
