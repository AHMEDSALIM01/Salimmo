package org.propertyservice.security;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    private static final String AGENT_IMMOBOLIER = "AGENT_IMMOBILIER";
    private static final String API_V_1_PROPERTY = "/api/v1/property/";
    private static final String API_V_1_PROPERTY_ID = "/api/v1/property/{id}";
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/swagger-ui/**", API_V_1_PROPERTY,API_V_1_PROPERTY_ID).permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, API_V_1_PROPERTY).hasAuthority(AGENT_IMMOBOLIER);
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, API_V_1_PROPERTY,API_V_1_PROPERTY_ID).hasAnyAuthority(AGENT_IMMOBOLIER,"ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, API_V_1_PROPERTY).hasAuthority(AGENT_IMMOBOLIER);
        http.authorizeRequests().anyRequest().permitAll();
    }

}
