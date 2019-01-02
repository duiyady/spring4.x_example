package com.duiya.one;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:com/duiya/one/test.properties")
public class ElConfig {
    @Value("test测试") //①注入普通字符
    private String normal;

    @Value("#{systemProperties['os.name']}") //②注入操作系统属性
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.0 }") //③注入表达式运算结果
    private double randomNumber;

    @Value("#{valueDemo.string}") //④注入其他Bean的属性
    private String fromAnother;

    @Value("classpath:com/duiya/one/note.txt") //⑤注入文件内容
    private Resource testFile;

    @Value("http://www.baidu.com") //⑥注入网址内容
    private Resource testUrl;

    @Value("${book.name}") //⑦注入属性文件
    private String bookName;

    @Autowired
    private Environment environment; //⑦注入属性文件


    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
