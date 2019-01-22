package eu.dariah.has.ddrs.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.dariah.has.ddrs.service.ShibbolethAuthenticationUniqueId;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class ShibbolethAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Object uid = request.getAttribute("unique-id");
        if(uid != null) {
            if (StringUtils.isNotEmpty(uid.toString())) {
                // Create our Authentication and let Spring know about it
                Authentication auth = new ShibbolethAuthenticationUniqueId(uid.toString());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }

}
