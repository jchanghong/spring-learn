package com.example.springlearn.core.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.servlet.ServletConfig;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: jiang
 * \* Date: 2019/11/21
 * \* Time: 20:27
 * \
 */
@Component
//@EnableLoadTimeWeaving
@Configuration
@Primary
@Service
@Repository
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@SessionScope
@ComponentScan(basePackages = {"com.example.springlearn.core.ioc"},
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Stub.*Repository"),
        excludeFilters = @ComponentScan.Filter(Repository.class))
@PropertySource("classpath:application.properties")
public class BeanWeb implements Lifecycle, ApplicationContextAware , ServletConfigAware {
    @PostConstruct
    public void init() {
        System.out.println("init"+port);
    }

    @Value("dsdsd${user.home}dsds")
    String port;

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {

        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        System.out.println(servletConfig.getInitParameterNames());
    }
}
