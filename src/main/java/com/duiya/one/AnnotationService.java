package com.duiya.one;

import org.springframework.stereotype.Service;

/**
 * 使用注解被拦截的类
 */
@Service
public class AnnotationService {

    @Action(name="注解式拦截的add操作")
    public void add(){
        System.out.println("===========annotationService.add==========");
    }
}
