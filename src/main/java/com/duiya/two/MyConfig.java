package com.duiya.two;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan
@EnableAsync//利用@EnableAsync注解开启异步任务支持
@EnableScheduling//通过@EnableScheduling注解开启对计划任务的支持。
//配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，并返回ThreadPoolTaskExecutor ，这样就获得了一个基于线程池的TaskExecutor。
public class MyConfig implements AsyncConfigurer {

    //配置spring多线程支持
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    //配置条件注解Conditional
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListServide(){
        return new WindowsListService();
    }
    @Bean
    @Conditional(MacCondition.class)
    public ListService linuxListServide(){
        return new MacListService();
    }
}
