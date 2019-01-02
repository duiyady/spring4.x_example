package com.duiya.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseService2 {

    @Autowired
    private BaseService baseService;

    public void sayHello(){
        System.out.println(baseService.say("world"));
    }
}
