package eu.dariah.has.ddrs.conf;

import eu.dariah.has.ddrs.filter.ShibbolethAuthenticationFilter;
import eu.dariah.has.ddrs.service.ShibbolethAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by yoann on 12.06.17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bcryptEncoder;
    private final ShibbolethAuthenticationProvider shibbolethAuthenticationProvider;

    @Value("${ddrs.admin.encoded.password}")
    private String encodedAdminPassword;

    @Autowired
    public SecurityConfiguration(BCryptPasswordEncoder bcryptEncoder, ShibbolethAuthenticationProvider shibbolethAuthenticationProvider) {
        this.bcryptEncoder = bcryptEncoder;
        this.shibbolethAuthenticationProvider = shibbolethAuthenticationProvider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(bcryptEncoder)
                .withUser("admin").password(encodedAdminPassword).authorities("ROLE_ADMIN");
        auth.authenticationProvider(shibbolethAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/*", "/auth/**").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_SHIBBOLETH").anyRequest().authenticated()

                .and().formLogin().loginPage("/auth/login").failureUrl("/auth/login?error=true").defaultSuccessUrl("/")
                .loginProcessingUrl("/auth/loginuser").usernameParameter("username").passwordParameter("password")

                .and().logout().invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")).logoutSuccessUrl("/")

                .and().exceptionHandling().accessDeniedPage("/access-denied")

//                .and().requiresChannel().antMatchers("/**").requiresInsecure() //Breaks the AJP connector!!!!!

                .and().rememberMe()
                .and().addFilterBefore(new ShibbolethAuthenticationFilter(), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/fonts/**", "/css/**", "/js/**", "/images/**");
    }

}