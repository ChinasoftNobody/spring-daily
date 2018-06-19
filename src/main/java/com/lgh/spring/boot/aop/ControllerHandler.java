package com.lgh.spring.boot.aop;

import com.lgh.spring.boot.common.AuthResponse;
import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.service.auth.AuthService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 *
 * @author Administrator
 * @date 2017/5/7
 */
@Aspect
@Component
public class ControllerHandler {
    @Resource
    private AuthService authService;

    private static Logger logger = LoggerFactory.getLogger(ControllerHandler.class);
    @Pointcut("execution( * com.lgh.spring.boot.controller.*.*(..))")
    public void pointCutAt() {
    }

    @Around("pointCutAt()")
    public Response beforeAction(ProceedingJoinPoint joinPoint) {
        long beginTime = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        AuthResponse authResponse = authService.validAuth(joinPoint,request);
        if(authResponse != null && !authResponse.isAccess()){
            logger.info("[time:{}ms] Auth not access:{}",System.currentTimeMillis() - beginTime,authResponse.getMsg());
            return ResponseUtil.failed(authResponse);
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method controller = signature.getMethod();
        Response response;
        try {
            response = (Response) joinPoint.proceed();
        }catch (Throwable e){
            response = ResponseUtil.failed(e.getMessage());
        }finally {
            logger.info("[time:{}ms] Request method:{}",System.currentTimeMillis() - beginTime,controller);
        }
        return response;
    }
}
