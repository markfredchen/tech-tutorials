package tech.markfredchen.spring.security.multiple.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;

    public AuthServerConfiguration(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("mc-password")
                .secret("$2a$10$exFwZt5OvdLRdCLFwFMBvOSdoVsxy.OnKJ9Bg091kUAQSH4Ht/aYu")
                .accessTokenValiditySeconds(10000)
                .refreshTokenValiditySeconds(300000)
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                .scopes("write", "read")
                .and()
                .withClient("mc-authorization-code")
                .secret("$2a$10$exFwZt5OvdLRdCLFwFMBvOSdoVsxy.OnKJ9Bg091kUAQSH4Ht/aYu")
                .authorizedGrantTypes("authorization_code", "implicit")
                .scopes("all")
                .redirectUris("http://localhost:8000/sso")
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(1200)
                .autoApprove("all")
                .refreshTokenValiditySeconds(50000);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .realm("oauth2-resources")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();

    }
}
