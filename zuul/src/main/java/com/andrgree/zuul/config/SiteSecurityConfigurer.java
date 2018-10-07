package com.andrgree.zuul.config;

//@Configuration
//@EnableOAuth2Sso
public class SiteSecurityConfigurer
        /*extends WebSecurityConfigurerAdapter*/ {


 /*   @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Override
    protected void configure(HttpSecurity http)
        throws Exception {
        http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/webjars/**", "/actuator/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .permitAll()
            .and().headers().frameOptions().sameOrigin()    //нужно для h2 консоли
            .and().csrf().disable();
        //.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Bean
    @Primary
    public OAuth2RestOperations codeOauth2Template(OAuth2ProtectedResourceDetails resource) {
        return new OAuth2RestTemplate(resource, oauth2ClientContext);
    }

*/

}
