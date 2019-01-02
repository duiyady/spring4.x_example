package com.duiya.one;

import org.springframework.context.annotation.*;

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

    //测试bean构造函数后和销毁前
    @Bean(initMethod = "init", destroyMethod = "destroy")
    BeanWayService getBeanWayService(){
        return new BeanWayService();
    }
    @Bean
    JSR250WayService getJSR250WayService(){
        return new JSR250WayService();
    }

    //测试profile为不同环境使用不同配置
    @Bean
    @Profile("dev") //①
    public DemoBean devDemoBean() {
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod") //②
    public DemoBean prodDemoBean() {
        return new DemoBean("from production profile");
    }
}
