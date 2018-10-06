package com.andrgree.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
@Order(6)
public class AuthServerSymmetricConfigurer extends AuthorizationServerConfigurerAdapter {

    @Value("${jwt.symmetric-key}")
    private String keyPassword;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(
        ClientDetailsServiceConfigurer clients)
        throws Exception {
        clients
            .inMemory()
            .withClient("polis")
            .secret("polis")
            //.redirectUris("http://localhost:8080/")
            .authorizedGrantTypes("authorization_code","refresh_token")
            .scopes("read")
            .autoApprove(true)
            .accessTokenValiditySeconds(300)
            .refreshTokenValiditySeconds(1800);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
            .tokenStore(tokenStore())
            .accessTokenConverter(jwtAccessTokenConverter())
            .userDetailsService(userDetailsService);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(keyPassword);

        return converter;
    }
}