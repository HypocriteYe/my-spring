package com.example.myspring.config;

import com.example.myspring.injector.CustomerSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @Author ygl
 * @Create 2024/7/5 13:25
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public CustomerSqlInjector customerSqlInjector() {
        return new CustomerSqlInjector();
    }
}
