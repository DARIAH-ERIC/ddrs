package eu.dariah.has.ddrs.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;

@Component
public class ShibbolethAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOG = Logger.getLogger(ShibbolethAuthenticationProvider.class);

    @Autowired
    private HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = request.getAttribute("unique-id" ).toString();

        ShibbolethAuthenticationUniqueId shibbolethAuthenticationUniqueId = (ShibbolethAuthenticationUniqueId) authentication;
        String uid = shibbolethAuthenticationUniqueId.getUid();
//        if(uid == null){
//            throw new Exception("Could not find user with ID: " + uid);
//        }
        Collection<GrantedAuthority> grantedAuths = Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
        Authentication auth = new UsernamePasswordAuthenticationToken(uid, null, grantedAuths);
        LOG.info(auth);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
