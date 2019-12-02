package tech.markfredchen.spring.cloud.feign.bar.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FeignBarServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignBarServiceApplication.class);
    }
}
