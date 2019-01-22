package eu.dariah.has.ddrs.service;

import org.apache.log4j.Logger;
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

    private static final Logger LOG = Logger.getLogger(ShibbolethAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication instanceof ShibbolethAuthenticationToken) {
            ShibbolethAuthenticationToken shibbolethAuthenticationToken = (ShibbolethAuthenticationToken) authentication;
            String uid = shibbolethAuthenticationToken.getUid();
            //        if(uid == null){
            //            throw new Exception("Could not find user with ID: " + uid);
            //        }
            Collection<GrantedAuthority> grantedAuths = Collections.singleton(new SimpleGrantedAuthority("ROLE_SHIBBOLETH"));
            Authentication auth = new UsernamePasswordAuthenticationToken(uid, null, grantedAuths);
            LOG.info(auth);
            return auth;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(ShibbolethAuthenticationToken.class) || authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
