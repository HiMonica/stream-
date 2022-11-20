package com.example.sentineldemo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

/**
 * @author julu
 * @date 2022/11/8 21:44
 */
@Aspect
@Configuration
public class AspectTest {

    @Pointcut("@annotation(com.example.sentineldemo.aspect.MyAspect)")
    public void aspectTest(){

    }

    @Before("aspectTest()")
    public void test(JoinPoint joinPoint){
        System.out.println("123");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(JSON.toJSONString(signature));
    }
}
