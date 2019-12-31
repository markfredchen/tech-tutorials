package tech.markfredchen.spring.security.multiple.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author markfredchen
 * @since 2019/12/4
 */
@Slf4j
@Component
public class FooAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials()
                .toString();
        log.info("username:password={}:{}", username, password);
        if ("foo-user".equals(username) && "foo-pass".equals(password)) {
            return new UsernamePasswordAuthenticationToken
                    (username, password, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        } else {
            throw new
                    BadCredentialsException("External system authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
