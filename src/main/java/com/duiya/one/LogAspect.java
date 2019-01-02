package com.duiya.one;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //通过@Aspect注解声明该类是一个切面。
@Component //通过@Component让此切面成为Spring容器管理的Bean。
public class LogAspect {

    @Pointcut("@annotation(com.duiya.one.Action)") //通过@Pointcut注解声明切面。
    public void annotationPointCut(){};

    @Before("annotationPointCut()")
    public void beforeAnno(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截before" + action.name());
    }

    @Around("annotationPointCut()")
    public void aroundAnno(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截around1" + action.name());
        proceedingJoinPoint.proceed();
        System.out.println("注解式拦截around2" + action.name());
    }

    @After("annotationPointCut()") //通过@After注解声明一个建言，并使用@Pointcut定义的切点。
    public void afterAnno(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截after" + action.name()); //通过反射可以获得注解上面的属性，然后做日志记录相关的操作，下面的相同。
    }

    @Before("execution(* com.duiya.one.MethodService.*(..))") //通过@Before注解声明一个建言，此建言直接使用拦截规则作为参数。
    public void beforeMet(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截before  "+method.getName());
    }

    @Around("execution(* com.duiya.one.MethodService.*(..))")
    public void aroundMet(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截around1  "+method.getName());
        proceedingJoinPoint.proceed();
        System.out.println("方法规则式拦截around2  "+method.getName());
    }

    @After("execution(* com.duiya.one.MethodService.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截after  "+method.getName());
    }
}