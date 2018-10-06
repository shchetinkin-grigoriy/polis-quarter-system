package com.andrgree.auth.config;

import com.andrgree.auth.security.SecUserAuthenticationProvider;
import com.andrgree.auth.security.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Autowired
    //@Qualifier("dbUserDetailsService")
    SecUserDetailsService userDetailsService;

    @Autowired
    SecUserAuthenticationProvider accountAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http.requestMatchers()
                .antMatchers("/login", "/actuator/**" , "/oauth/authorize", "/h2-console/**")
                .and()
                .authorizeRequests()
                .antMatchers( "/h2-console/**").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and().headers().frameOptions().sameOrigin()    //нужно для h2 консоли
                .and().csrf().disable();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(accountAuthenticationProvider);
    }


    /*@Override
    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsServiceBean()
        throws Exception {
        return super.userDetailsServiceBean();
    }*/

}
