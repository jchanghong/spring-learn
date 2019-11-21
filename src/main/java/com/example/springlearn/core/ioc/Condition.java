package com.example.springlearn.core.ioc;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: jiang
 * \* Date: 2019/11/21
 * \* Time: 21:32
 * \
 */
//@Profile("default1")
@ConditionalOnJava(value = JavaVersion.EIGHT)
@Component
public class Condition {
    @PostConstruct
    public void init() {
        System.out.println("Condition inited");
    }
}
