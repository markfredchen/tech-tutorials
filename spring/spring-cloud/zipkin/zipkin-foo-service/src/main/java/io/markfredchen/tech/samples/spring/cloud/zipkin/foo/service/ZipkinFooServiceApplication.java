package io.markfredchen.tech.samples.spring.cloud.zipkin.foo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author markfredchen
 * @since 2019/11/26
 */
@SpringBootApplication
public class ZipkinFooServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinFooServiceApplication.class);
    }
}

