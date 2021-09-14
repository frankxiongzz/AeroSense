package com.norm.weather.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter();
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverter());
    }
    
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
      for (HttpMessageConverter<?> converter :converters) {
        if (converter instanceof StringHttpMessageConverter) {
          ((StringHttpMessageConverter) converter).setWriteAcceptCharset(false);
        }
      }
    }
}
