package tech.markfredchen.spring.security.azure.ad.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;

/**
 * @author markfredchen
 * @since 2019/12/7
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfiguration {
}
