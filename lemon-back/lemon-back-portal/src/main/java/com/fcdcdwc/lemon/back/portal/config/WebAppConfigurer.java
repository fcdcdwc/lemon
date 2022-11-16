//package com.fcdcdwc.lemon.back.portal.config;
//
//
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@Configuration
//public class WebAppConfigurer implements WebMvcConfigurer, WebMvcRegistrations {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(0, new MappingJackson2HttpMessageConverter());
//    }
//
//}
