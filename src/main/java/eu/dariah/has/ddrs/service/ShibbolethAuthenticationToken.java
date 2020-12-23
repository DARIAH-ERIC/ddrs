package eu.dariah.has.ddrs.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class ShibbolethAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -1249976839306453197L;
//    private User authenticatedUser;
    private String uid;

    public ShibbolethAuthenticationToken(String uid){
        super(Arrays.asList());
        this.uid = uid;
    }

//    public ShibbolethAuthenticationToken(Collection<? extends GrantedAuthority> authorities, User authenticatedUser, Long uid) {
    public ShibbolethAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String uid) {
        super(authorities);
        this.uid = uid;
//        this.authenticatedUser = authenticatedUser;
    }

    @Override
    public Object getCredentials() {
        return uid;
    }

    @Override
    public Object getPrincipal() {
        return uid;
    }

    public String getUid() {
        return uid;
    }

}