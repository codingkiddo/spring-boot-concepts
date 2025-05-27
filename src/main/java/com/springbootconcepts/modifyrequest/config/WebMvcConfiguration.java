package com.springbootconcepts.modifyrequest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springbootconcepts.modifyrequest.interceptor.EscapeHtmlRequestInterceptor;


@Configuration
//@Profile("interceptorExample")
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	logger.info("addInterceptors() called");
        registry.addInterceptor(new EscapeHtmlRequestInterceptor()).addPathPatterns("/**");

        WebMvcConfigurer.super.addInterceptors(registry);

    }
}