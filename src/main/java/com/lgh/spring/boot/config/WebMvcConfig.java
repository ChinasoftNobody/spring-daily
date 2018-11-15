package com.lgh.spring.boot.config;

import com.lgh.spring.boot.aop.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 * @date 2017/3/29
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(loginInterceptor);
        // 排除配置
        addInterceptor.excludePathPatterns("/static/**");
        addInterceptor.excludePathPatterns("/templates/**");
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/dashboard");
        addInterceptor.excludePathPatterns("/user/login");
        addInterceptor.excludePathPatterns("/user/register");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }
}
