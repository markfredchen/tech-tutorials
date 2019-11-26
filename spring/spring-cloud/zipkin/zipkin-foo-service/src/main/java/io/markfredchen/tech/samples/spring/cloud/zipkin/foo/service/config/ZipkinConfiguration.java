package io.markfredchen.tech.samples.spring.cloud.zipkin.foo.service.config;

import brave.http.HttpTracing;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author markfredchen
 * @since 2019/11/26
 */
@Configuration
public class ZipkinConfiguration {
    @Bean
    public RestTemplate restTemplate(HttpTracing tracing) {
        return new RestTemplateBuilder().additionalInterceptors(TracingClientHttpRequestInterceptor.create(tracing)).build();
    }
}
