package com.duiya.one;


public class BaseService4 {

    private BaseService3 baseService3;

    public void sayHello(){
        System.out.println(baseService3.say("world"));
    }

    /**
     * 通过java配置时，注入对象需要set方法
     * @param baseService3
     */
    public void setBaseService3(BaseService3 baseService3) {
        this.baseService3 = baseService3;
    }
}
