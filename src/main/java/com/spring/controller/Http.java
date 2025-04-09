package com.spring.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class Http {

        @Bean
        public HttpClient httpClient() {
            return HttpClient.newHttpClient();
        }
}
