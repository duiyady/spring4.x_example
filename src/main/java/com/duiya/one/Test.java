package com.duiya.one;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
       // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        //测试profile时用这个
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev"); //先将活动的Profile设置为prod
        context.register(MyConfig.class);//后置注册Bean配置类，不然会报Bean未定义的错误。
        context.refresh(); //刷新容器

        /*测试注入*/
//        /*getBean可以通过class类型，也可以根据名字，名字就是注解后面自己定义的，默认是首字母小写*/
////        BaseService2 baseService2 = context.getBean(BaseService2.class);
//        BaseService2 baseService2 = (BaseService2) context.getBean("baseService2");
//        baseService2.sayHello();
//
////        BaseService4 baseService4 = (BaseService4) context.getBean("getBaseService4");
//        BaseService4 baseService4 = context.getBean(BaseService4.class);
//        baseService4.sayHello();

        /*测试切面aop*/
//        AnnotationService annotationService = context.getBean(AnnotationService.class);
//        MethodService methodService = context.getBean(MethodService.class);
//        annotationService.add();
//        methodService.add();

        /*测试value注入值*/
//        ValueDemo valueDemo = context.getBean(ValueDemo.class);
//        System.out.println(valueDemo.getString());
//
//        ElConfig elConfig = context.getBean(ElConfig.class);
//        elConfig.outputResource();

        /*测试bean前bean后方法*/
//        BeanWayService beanWayService = context.getBean(BeanWayService.class);
//        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);

        //测试profile为不同环境使用不同配置
//        DemoBean demoBean = context.getBean(DemoBean.class);
//        System.out.println(demoBean.getContent());


        //测试Spring事件
//        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
//        demoPublisher.publish("hello application event");




        context.close();

    }
}
