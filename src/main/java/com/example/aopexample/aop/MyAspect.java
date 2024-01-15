package com.example.aopexample.aop;

import com.example.aopexample.annotation.LogTransformation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Around("@annotation(com.example.aopexample.annotation.LogTransformation)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        var ann = signature.getMethod().getAnnotation(LogTransformation.class);
        System.out.println("Пишем в файл: "+ann.value());


        System.out.println("Имя метода: " + joinPoint.getSignature().getName());
        var args = joinPoint.getArgs();
        for (Object arg: args) {
            System.out.println("Arg: " + arg);
        }

        Object proceed = joinPoint.proceed();   //выполняем метода
        System.out.println("Результат работы метода:"+proceed);

        return proceed;
    }
}
