package com.example.springlearn.core.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.PostConstruct;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: jiang
 * \* Date: 2019/11/21
 * \* Time: 19:29
 * \
 */
@Configuration
public class IocTest {
    @Autowired
   public StringBuilder stringBuilder;
    @PostConstruct
    public void init() {
        System.out.println("ioc create");
    }

    public static void main(String[] args) {
        BeanFactory beanFactory;
    }
}
