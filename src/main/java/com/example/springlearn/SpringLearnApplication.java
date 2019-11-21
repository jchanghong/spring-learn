package com.example.springlearn;

import com.example.springlearn.core.ioc.Bean2;
import com.example.springlearn.core.ioc.Config;
import com.example.springlearn.core.ioc.IocTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sound.midi.Soundbank;

@SpringBootApplication
@Configuration
@Import({IocTest.class})
public class SpringLearnApplication implements CommandLineRunner {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext();
//        context.scan("com.example");
//        context.refresh();
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(SpringLearnApplication.class);
        springApplicationBuilder.registerShutdownHook(true);
        SpringApplication application = springApplicationBuilder.build();
        ConfigurableApplicationContext run = application.run(args);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("shunt...........");
            }
        });
        run.registerShutdownHook();
    }

    @Autowired
    @Qualifier("webApplicationContext")
    ApplicationContext applicationContext;
    @Autowired
    Bean2 bean2;
    @Autowired
    IocTest iocTest;
    @Autowired
    Config config;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(applicationContext.getApplicationName());
        System.out.println(bean2.stringBuilder==iocTest.stringBuilder);

    }
}
