package tech.markfredchen.spring.cloud.feign.foo.service;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignFooServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignFooServiceApplication.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}
