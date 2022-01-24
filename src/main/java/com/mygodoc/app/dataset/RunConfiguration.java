package com.mygodoc.app.dataset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RunConfiguration {
    @Value("${browser}")
    String browser;

    @Value("${testType}")
    String testType;

    @Value("${userId}")
    String userId;

    @Value("${pwd}")
    String pwd;
}
