package eu.dariah.has.ddrs.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by yoann on 12.06.17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bcryptEncoder;

    @Value("${ddrs.admin.encoded.password}")
    private String encodedAdminPassword;

    @Autowired
    public SecurityConfiguration(BCryptPasswordEncoder bcryptEncoder) {
        this.bcryptEncoder = bcryptEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(bcryptEncoder)
                .withUser("admin").password(encodedAdminPassword).authorities("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/*", "/auth/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN").anyRequest().authenticated()

                .and().formLogin().loginPage("/auth/login").failureUrl("/auth/login?error=true").defaultSuccessUrl("/")
                .loginProcessingUrl("/auth/loginuser").usernameParameter("username").passwordParameter("password")

                .and().logout().invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")).logoutSuccessUrl("/")

                .and().exceptionHandling().accessDeniedPage("/access-denied")

                .and().requiresChannel().antMatchers("/**").requiresInsecure()

                .and().rememberMe();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/fonts/**", "/css/**", "/js/**", "/images/**");
    }

}