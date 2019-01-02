package com.duiya.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;//注入ApplicationContext 用来发布事件。

    public void publish(String msg){
        applicationContext.publishEvent(new DemoEvent(this, msg));//使用ApplicationContext 的publishEvent方法来进行发布。
    }

}
