package eu.dariah.has.ddrs.service.auth;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomOidcUserService extends OidcUserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomOidcUserService.class);
    private final static String ENTITLEMENTS = "edu_person_entitlements";
    private final static String ADMIN_ENTITLEMENT = "urn:mace:egi.eu:group:vo.operas-eu.org:PSP:admins:role=member#aai.egi.eu";
    private final static String SERVICEPROVIDER_ENTITLEMENT = "urn:mace:egi.eu:group:vo.operas-eu.org:PSP:ServiceProviders:role=member#aai.egi.eu";

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        Set<GrantedAuthority> mappedAuthorities = new HashSet<>(oidcUser.getAuthorities());
        Object object = oidcUser.getAttribute(ENTITLEMENTS);
        if(object instanceof List) {
            List<String> entitlements = (List<String>)object;
            for(String entitlement : entitlements) {
                if(entitlement.equals(ADMIN_ENTITLEMENT)) {
                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                } else if(entitlement.equals(SERVICEPROVIDER_ENTITLEMENT)) {
                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_SERVICEPROVIDER"));
                }
            }
        }

        oidcUser = new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
        try {
            return oidcUser;
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }
}
