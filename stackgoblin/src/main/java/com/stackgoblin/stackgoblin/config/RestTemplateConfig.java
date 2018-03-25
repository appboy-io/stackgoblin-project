package com.stackgoblin.stackgoblin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    private static final Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class);

    @Bean(name = "stackGoblinRestTemplate")
    RestTemplate stackGoblinRestTemplate() {
        ClientHttpRequestInterceptor interceptor = (HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
            logger.info(String.format("request to URI %s with HTTP verb '%s'", request.getURI(), request.getMethod().toString()));
            return execution.execute(request, body);
        };

        return new RestTemplateBuilder().additionalInterceptors(interceptor).build();
    }
}
