package com.mygodoc.app.utils;

import com.github.javafaker.Faker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseUtils {
    @Bean
    public Faker getFaker(){
        return new Faker();
    }

    @Bean
    public Log getLogger(){
        return LogFactory.getLog(getClass()); }
}
