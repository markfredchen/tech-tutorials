package io.markfredchen.tech.samples.spring.cloud.zipkin.bar.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author markfredchen
 * @since 2019/11/26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZipkinBarServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinBarServiceApplication.class);
    }
}


