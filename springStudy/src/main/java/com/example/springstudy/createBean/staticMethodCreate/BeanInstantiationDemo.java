package com.example.springstudy.createBean.staticMethodCreate;

import com.example.springstudy.createBean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建bean的第一种方式，通过静态方法构建
 *
 * @author julu
 * @date 2022/11/20 11:28
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println(user);
    }
}
