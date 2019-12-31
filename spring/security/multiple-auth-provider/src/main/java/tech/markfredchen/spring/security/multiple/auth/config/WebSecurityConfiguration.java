package tech.markfredchen.spring.security.multiple.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import tech.markfredchen.spring.security.multiple.auth.service.BarAuthenticationProvider;
import tech.markfredchen.spring.security.multiple.auth.service.FooAuthenticationProvider;

/**
 * @author markfredchen
 * @since 2019/11/28
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final BarAuthenticationProvider barAuthProvider;
    private final FooAuthenticationProvider fooAuthProvider;

    public WebSecurityConfiguration(BarAuthenticationProvider barAuthProvider, FooAuthenticationProvider fooAuthProvider) {
        this.barAuthProvider = barAuthProvider;
        this.fooAuthProvider = fooAuthProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(fooAuthProvider);
        auth.authenticationProvider(barAuthProvider);
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$10$exFwZt5OvdLRdCLFwFMBvOSdoVsxy.OnKJ9Bg091kUAQSH4Ht/aYu")
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .and()
                .withUser("employee")
                .password("$2a$10$exFwZt5OvdLRdCLFwFMBvOSdoVsxy.OnKJ9Bg091kUAQSH4Ht/aYu")
                .authorities("ROLE_USER");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .requestMatchers().antMatchers("/oauth/**","/login/**","/logout/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .formLogin().permitAll();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
