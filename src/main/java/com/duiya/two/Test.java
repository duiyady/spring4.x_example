package com.duiya.two;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        //spring aware
//        AwareService awareService = context.getBean(AwareService.class);
//        awareService.outputResoult();

        //测试Spring多线程
//        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
//        for(int i = 0; i < 10; i++){
//            asyncTaskService.executeAsyncTask(i);
//            asyncTaskService.executeAsyncTaskPlus(i);
//        }

        //测试Conditional条件注解
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + ":" + listService.showListCmd());




        //context.close();
    }
}
