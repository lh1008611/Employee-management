package com.chuangyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拓展springmvc
//如果需要定制化功能，只需要写这个组件，然后交给sprigboot，sb就会帮我们自动装配
@Configuration
//@EnableWebMvc   //就是导入了一个类：DelegatingWebMvcConfiguration：从容器中获取所有WebMvcConfig
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
//        registry.addViewController("/main.html").setViewName("index");
        registry.addViewController("/pages-profile.html").setViewName("pages-profile");
        registry.addViewController("/table-basic.html").setViewName("table-basic");
        registry.addViewController("/icon-material.html").setViewName("icon-material");
        registry.addViewController("/map-google.html").setViewName("map-google");
        registry.addViewController("/pages-blank.html").setViewName("pages-blank");
        registry.addViewController("/pages-error-404.html").setViewName("pages-error-404");
        registry.addViewController("/login.html").setViewName("login");
    }

    //自定义国际化组件
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/login");
    }
}
