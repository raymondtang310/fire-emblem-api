package com.github.raymondtang310.fireemblemapi.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * BasicAuthenticationSecurityConfiguration is a {@link Configuration} that sets up basic authentication for this Spring
 * Boot application.
 * <p>
 * Created February 05, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0.0
 */
@Configuration
@Profile("test") // Enable basic authentication for the test environment only
@EnableWebSecurity
public class BasicAuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * Configures the specified {@link HttpSecurity} so that all requests are required to be authenticated via basic
     * authentication.
     *
     * @param httpSecurity the {@link HttpSecurity} to configure
     * @throws Exception if an error occurs while configuring the {@link HttpSecurity}
     * @since 1.0.0
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    /**
     * Configures authentication, setting the username, password, and roles.
     *
     * @param authenticationManagerBuilder the {@link AuthenticationManagerBuilder} for building authentication
     * @throws Exception if an error occurs while building authentication
     * @since 1.0.0
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(System.getenv("BASIC_AUTH_USERNAME"))
                .password("{noop}" + System.getenv("BASIC_AUTH_PASSWORD"))
                .roles("USER");
    }
}
