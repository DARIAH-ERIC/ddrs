package eu.dariah.has.ddrs.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class ShibbolethAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOG = LogManager.getLogger(ShibbolethAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ShibbolethAuthenticationToken shibbolethAuthenticationToken = (ShibbolethAuthenticationToken) authentication;
        String uid = shibbolethAuthenticationToken.getUid();
        Collection<GrantedAuthority> grantedAuths = Collections.singleton(new SimpleGrantedAuthority("ROLE_SHIBBOLETH"));
        return new UsernamePasswordAuthenticationToken(uid, null, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(ShibbolethAuthenticationToken.class);
    }
}
