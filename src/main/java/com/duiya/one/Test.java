package com.duiya.one;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        /*getBean可以通过class类型，也可以根据名字，名字就是注解后面自己定义的，默认是首字母小写*/
//        BaseService2 baseService2 = context.getBean(BaseService2.class);
        BaseService2 baseService2 = (BaseService2) context.getBean("baseService2");
        baseService2.sayHello();

//        BaseService4 baseService4 = (BaseService4) context.getBean("getBaseService4");
        BaseService4 baseService4 = context.getBean(BaseService4.class);
        baseService4.sayHello();

        AnnotationService annotationService = context.getBean(AnnotationService.class);
        MethodService methodService = context.getBean(MethodService.class);

        annotationService.add();
        methodService.add();

        ValueDemo valueDemo = context.getBean(ValueDemo.class);
        System.out.println(valueDemo.getString());

        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outputResource();


        context.close();

    }
}
