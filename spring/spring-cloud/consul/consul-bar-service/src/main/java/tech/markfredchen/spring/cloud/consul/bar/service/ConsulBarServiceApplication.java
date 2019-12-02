package tech.markfredchen.spring.cloud.consul.bar.service;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulBarServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulBarServiceApplication.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}
