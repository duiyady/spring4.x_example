package com.duiya.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy//开启Spring对AspectJ的支持。
public class MyConfig {

    @Bean
    public BaseService3 getBaseServide3(){
        return new BaseService3();
    }

    @Bean
    BaseService4 getBaseService4(BaseService3 baseService3){
        BaseService4 baseService4 = new BaseService4();
        baseService4.setBaseService3(baseService3);
        return baseService4;
    }

//    @Bean
//    BaseService4 getBaseService4(){
//        BaseService4 baseService4 = new BaseService4();
//        baseService4.setBaseService3(getBaseServide3());
//        return baseService4;
//    }
}
