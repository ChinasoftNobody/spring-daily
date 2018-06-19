package com.lgh.spring.boot.service.auth;

import com.lgh.spring.boot.common.AuthResponse;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 * @date 2017/5/7
 */
public interface AuthService {
    /**
     * 权限验证
     * @param joinPoint 切点
     * @param request 请求体
     * @return 验证结果
     */
    AuthResponse validAuth(ProceedingJoinPoint joinPoint, HttpServletRequest request);
}
