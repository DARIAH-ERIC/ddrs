package eu.dariah.has.ddrs.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.dariah.has.ddrs.service.ShibbolethAuthenticationUniqueId;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class ShibbolethAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String uid = request.getHeader("unique-id");
        Long id = Long.parseLong(uid);

        // Create our Authentication and let Spring know about it
        Authentication auth = new ShibbolethAuthenticationUniqueId(id);
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }

}
