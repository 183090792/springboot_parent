package com.fb.base.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author LYZ
 * @create 2018/12/29 15:02
 * 业务层异常切面
 **/
@Aspect
@Component
@Slf4j
public class ServiceExceptionAspect {
    @Pointcut("execution(public * com.fb.*.service.impl.*.*(..))")
    private void methodException(){

    }
    @AfterThrowing(pointcut = "methodException()",throwing = "e")
    public void doException(JoinPoint point,Throwable e){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        log.error("异常的方法名为=============>{}",method);
        if(e!=null){
            log.error("捕捉到的异常为===================>{}",e.getMessage());
            log.error("捕捉到的异常为===================>{}",e);
        }
    }
}
