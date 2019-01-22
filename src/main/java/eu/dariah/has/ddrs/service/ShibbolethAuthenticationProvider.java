package eu.dariah.has.ddrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class ShibbolethAuthenticationProvider implements AuthenticationProvider {
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
        return new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return uid;
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {
            }

            @Override
            public String getName() {
                return uid;
            }
        };
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
