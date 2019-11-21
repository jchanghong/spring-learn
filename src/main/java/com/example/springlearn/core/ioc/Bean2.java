package com.example.springlearn.core.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.beans.ConstructorProperties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: jiang
 * \* Date: 2019/11/21
 * \* Time: 19:58
 * \
 */
@Configuration
@DependsOn("stringBuilder")
@Component
@Controller
@RestController
public class Bean2   {
    @Autowired
   public StringBuilder stringBuilder;
    @Bean(name = "stringBuilder")
    @Description("test")
    @Scope("prototype")
    public static StringBuilder bean3() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder;
    }

    @Autowired
    @Resource
    BeanWeb beanWeb;

    @GetMapping("/test")
    public String web() {
        String s = beanWeb.toString();
        System.out.println(s);
        return "test" + s;
    }
    @ConstructorProperties({"a","b"})
    public  Bean2() {

    }
    @PostConstruct
    public void init() {
        System.out.println("bean2 create");
    }


}