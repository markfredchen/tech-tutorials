package tech.markfredchen.spring.cloud.consul.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author markfredchen
 * @since 2019/12/7
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigApplication.class);
    }
}

@RestController
class DemoRestController {
    @Value("${demo.message:error}")
    private String demoMessage;
    @Value("${global.message:error global message}")
    private String globalMessage;

    @GetMapping("/api/get/config")
    public Map<String, String> getConfigMessage() {
        Map<String, String> result = new HashMap<>(2);
        result.put("demoMessage", demoMessage);
        result.put("globalMessage", globalMessage);
        return result;
    }
}

@Slf4j
@Configuration
class ConsulConfigConfiguration {
    @Value("${demo.message:error}")
    private String demoMessage;

    @Value("${global.message:error global message}")
    private String globalMessage;

    @Bean
    public CommandLineRunner messageRunner() {
        return args -> {
            log.info(this.demoMessage);
            log.info(this.globalMessage);
        };
    }
}