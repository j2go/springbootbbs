package xyz.stg.bbs.config;

import xyz.stg.bbs.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by shitiangao on 16/7/19.
 */
@Configuration
@EnableWebSecurity
@EnableJpaAuditing
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService detailsService() {
        return new UserDetailServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .failureUrl("/login?error").permitAll()
                .and()
                    .logout().permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService());
    }

}
