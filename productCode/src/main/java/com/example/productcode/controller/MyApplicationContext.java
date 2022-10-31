package com.example.productcode.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author  julu
 * @date  2022/9/26 22:51
*/public class MyApplicationContext extends AbstractApplicationContext {
    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
        
    }

    @Override
    protected void closeBeanFactory() {

    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return null;
    }
}
