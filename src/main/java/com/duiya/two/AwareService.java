package com.duiya.two;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {//实现BeanNameAware,ResourceLoaderAware接口，获得Bean名称和资源加载的服务。
    private String beanName;
    private ResourceLoader resourceLoader;
    public void setBeanName(String s) {//实现BeanNameAware需要重写setBeanName方法。
        this.beanName = s;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {//实现ResourceLoaderAware需要重写setResourceLoader方法。
        this.resourceLoader = resourceLoader;
    }

    public void outputResoult(){
        System.out.println("bean的名称为：" + beanName);
        Resource resource = resourceLoader.getResource("classpath:com/duiya/two/note.txt");
        try {
            System.out.println("加载的文件为：" + IOUtils.toString(resource.getInputStream(), Charset.forName("utf8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
