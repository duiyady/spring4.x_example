package com.duiya.one;

import org.springframework.stereotype.Service;

@Service
public class BaseService {

    public String say(String msg){
        return "hello " + msg + "!";
    }
}
