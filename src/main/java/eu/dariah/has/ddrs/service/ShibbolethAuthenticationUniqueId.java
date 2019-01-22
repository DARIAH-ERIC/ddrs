package eu.dariah.has.ddrs.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class ShibbolethAuthenticationUniqueId extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -1249976839306453197L;
//    private User authenticatedUser;
    private Long uid;

    public ShibbolethAuthenticationUniqueId(Long uid){
        super(Arrays.asList());
        this.uid = uid;
    }

//    public ShibbolethAuthenticationUniqueId(Collection<? extends GrantedAuthority> authorities, User authenticatedUser, Long uid) {
    public ShibbolethAuthenticationUniqueId(Collection<? extends GrantedAuthority> authorities, Long uid) {
        super(authorities);
        this.uid = uid;
//        this.authenticatedUser = authenticatedUser;
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return uid;
    }

    public Long getUid() {
        return uid;
    }

}