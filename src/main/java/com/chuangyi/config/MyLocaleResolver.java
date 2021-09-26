package com.chuangyi.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求的语言参数
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();    //如果没有就使用默认
        if (!StringUtils.isEmpty(language)) { //如果语言参数不为空，则使用自定义，否则使用默认
            String[] CountriesAndRegions = language.split("_"); //国家，地区
            String country = CountriesAndRegions[0];
            String region = CountriesAndRegions[1];
            locale = new Locale(country, region);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
