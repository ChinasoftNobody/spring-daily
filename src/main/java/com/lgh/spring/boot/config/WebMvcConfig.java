package com.lgh.spring.boot.config;

import com.lgh.spring.boot.annotation.Fragment;
import com.lgh.spring.boot.aop.LoginInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2017/3/29
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer,ApplicationContextAware {

    private ApplicationContext applicationContext;
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
        addInterceptor.excludePathPatterns("/user/logout");
        addInterceptor.excludePathPatterns("/user/register");
        // 给加了Fragment注解的方法添加可访问权限
        accessFragment(addInterceptor);
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    // 给加了Fragment注解的方法添加可访问权限
    private void accessFragment(InterceptorRegistration addInterceptor) {
        Map<String, Object> controllers = this.applicationContext.getBeansWithAnnotation(Controller.class);
        Iterator<Map.Entry<String, Object>> entryIterator = controllers.entrySet().iterator();
        while (entryIterator.hasNext()){
            Class<?> aClass = entryIterator.next().getValue().getClass();
            String pathPrefix = "";
            RequestMapping requestMapping = aClass.getAnnotation(RequestMapping.class);
            if (requestMapping != null){
                String[] values = requestMapping.value();
                for (String value: values){
                    pathPrefix = value;
                    break;
                }
            }
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method:declaredMethods){
                if (method.getAnnotation(Fragment.class) == null){
                    continue;
                }
                GetMapping getMapping = method.getAnnotation(GetMapping.class);
                PostMapping postMapping = method.getAnnotation(PostMapping.class);
                if (getMapping != null){
                    String[] value = getMapping.value();
                    for (String s:value){
                        addInterceptor.excludePathPatterns(pathPrefix + s);
                        break;
                    }
                }else if (postMapping != null){
                    String[] value = postMapping.value();
                    for (String s:value){
                        addInterceptor.excludePathPatterns(pathPrefix + s);
                        break;
                    }
                }

            }
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
