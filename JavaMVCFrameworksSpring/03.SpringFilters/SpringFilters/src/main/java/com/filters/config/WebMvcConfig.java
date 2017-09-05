package com.filters.config;

import com.filters.interceptors.LogInterceptor;
import com.filters.interceptors.TitleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private final TitleInterceptor titleInterceptor;

    private final LogInterceptor logInterceptor;

    @Autowired
    public WebMvcConfig(
            TitleInterceptor titleInterceptor,
            LogInterceptor logInterceptor) {
        this.titleInterceptor = titleInterceptor;
        this.logInterceptor = logInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.titleInterceptor);
        registry.addInterceptor(this.logInterceptor);
    }
}
