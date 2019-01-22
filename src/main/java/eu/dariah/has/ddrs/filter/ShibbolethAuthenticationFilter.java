package eu.dariah.has.ddrs.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.dariah.has.ddrs.service.ShibbolethAuthenticationToken;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class ShibbolethAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger LOG = Logger.getLogger(ShibbolethAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Object uid = request.getAttribute("unique-id");
        if(uid != null) {
            LOG.info("UID from the filter is: " + uid);
            if (StringUtils.isNotEmpty(uid.toString())) {
                // Create our Authentication and let Spring know about it
                Authentication auth = new ShibbolethAuthenticationToken(uid.toString());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }

}
