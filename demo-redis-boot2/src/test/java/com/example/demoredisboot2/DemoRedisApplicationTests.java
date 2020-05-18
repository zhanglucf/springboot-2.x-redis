package com.example.demoredisboot2;

import com.example.demoredisboot2.bean.OrgTree;
import com.example.demoredisboot2.bean.Student;
import com.example.demoredisboot2.bean.Teacher;
import com.example.demoredisboot2.service.RedisService;
import com.example.demoredisboot2.utils.RedisUtil;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate1;

    @Autowired
    private RedisTemplate redisTemplate2;

    @Autowired
    private RedisTemplate redisTemplate3;

    @Autowired
    private RedisTemplate redisTemplate4;

    @Autowired
    private RedisTemplate redisTemplate5;

    @Autowired
    private RedisTemplate redisTemplate6;


    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("redisTemplate", "redisTemplate-value");
        stringRedisTemplate.opsForValue().set("stringRedisTemplate", "stringRedisTemplate-value");
        redisTemplate1.opsForValue().set("redisTemplate1", "redisTemplate1-value");
        redisTemplate2.opsForValue().set("redisTemplate2", "redisTemplate2-value");
        redisTemplate3.opsForValue().set("redisTemplate3", "redisTemplate3-value");
        redisTemplate4.opsForValue().set("redisTemplate4", "redisTemplate4-value");
        redisTemplate5.opsForValue().set("redisTemplate5", "redisTemplate5-value");
        redisTemplate6.opsForValue().set("redisTemplate6", "redisTemplate6-value");
    }

    @Test
    public void test() {
        OrgTree orgTree = new OrgTree(1L, "电科云", new Date(), 10000L, "上海分公司", 10001L, "张总");
        List<OrgTree> students = Arrays.asList(orgTree);
        RedisUtil redisUtil = new RedisUtil(redisTemplate4);
        redisUtil.expire("token",1000);
        redisUtil.hPut("token","jwt11",students);
        redisUtil.hPut("token","jwt",students);
        redisUtil.hPut("token","jwt2",students);
        redisUtil.hPut("token","jwt3",students);
        redisUtil.hPut("token","jwt4",students);
        redisUtil.hPut("token","jwt5",students);
        List<OrgTree> o = (List<OrgTree>) redisUtil.hGet("token", "jwt11");
        System.err.println(o.get(0).getName());
    }
}
