package com.example.springlearn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: jiang
 * \* Date: 2019/11/21
 * \* Time: 22:08
 * \
 */
@Aspect
@Component
public class AopTest {
    @Pointcut(value = "@annotation( org.springframework.web.bind.annotation.GetMapping)")
    public void pointcut() {

    }

    @After(value = "pointcut()")
    public void advice(JoinPoint joinPoint) {

        System.out.println(joinPoint.getArgs().toString());
    }
}
