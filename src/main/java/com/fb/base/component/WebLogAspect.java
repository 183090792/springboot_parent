package com.fb.base.component;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * @author LYZ
 * @create 2018/12/29 10:21
 * 日志切面
 **/
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    /**
     * http post请求方法
     */
    private static final String POST = "POST";
    /**
     * http get请求方法
     */
    private static final String GET = "GET";

    /**
     * 设置切点为controller公有方法的返回值
     */
    @Pointcut("execution(public * com.fb.*.controller.*.*(..))")
    public void webLog(){

    }

    /**
     * 设置切点为serviceImpl所有方法的返回值
     */
    @Pointcut("execution( * com.fb.*.service.impl.*.*(..))")
    public void serviceLog(){

    }
    @Before("webLog()")
    public void beforeWebLog(JoinPoint point){
        log.debug("====================================================日志开始打印================================================begin");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.debug("被请求的URL为====================>{}",request.getRequestURL());
        log.debug("http的请求方法为=================>{},",request.getMethod());
        log.debug("发起请求的IP为====================>{}",request.getRemoteAddr());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        log.debug("被请求的方法名为======================>{}",method);
        if(POST.equals(request.getMethod())){
            Object[] args = point.getArgs();
            log.debug("post参数为======>{}", JSONObject.toJSONString(args));
        }
        if(GET.equals(request.getMethod())){
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()){
                String element = parameterNames.nextElement();
                log.debug("get参数name=======>{},vale=======>{}",element,request.getParameter(element));
            }
        }
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.debug("返回的结果为==================>{} " , JSONObject.toJSONString(ret));
        log.debug("====================================================日志打印结束================================================end");
    }

    @AfterReturning(returning = "ret",pointcut = "serviceLog()")
    public void doServiceAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.debug("service层返回controller层的结果为============================================>{} " , JSONObject.toJSONString(ret));
    }
}
