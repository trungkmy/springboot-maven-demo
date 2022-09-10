package com.act.techtalk2022.config;

import com.act.techtalk2022.interceptor.PayloadInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final PayloadInterceptor payloadInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(payloadInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/health")
                .excludePathPatterns("/info");
    }

}
