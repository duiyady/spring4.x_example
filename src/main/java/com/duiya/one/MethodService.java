package com.duiya.one;

import org.springframework.stereotype.Service;

/**
 * 方法拦截规则被拦截的类
 */
@Service
public class MethodService {
    public void add(){
        System.out.println("===========methodService.add==========");
    }
}
