package com.example.myspring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @description Filter会先于Interceptor执行
 * @Author ygl
 * @Create 2024/8/6 10:43
 */
@Configuration

//@EnableWebMvc
public class WebMVCConfig implements WebMvcConfigurer {



    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new SingleArgResolver());
    }

}
