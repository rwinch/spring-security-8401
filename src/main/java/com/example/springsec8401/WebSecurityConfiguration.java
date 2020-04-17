/**
 * Copyright (c) Coveo Solutions Inc.
 */
package com.example.springsec8401;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class WebSecurityConfiguration
{
    @Configuration
    @EnableWebSecurity
    public static class SessionRequiredConfiguration extends WebSecurityConfigurerAdapter implements Ordered
    {
        @Override
        public int getOrder()
        {
            return Ordered.LOWEST_PRECEDENCE;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            // @formatter:off
            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers("/session/**").permitAll().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
            // @formatter:on
        }
    }

    @Configuration
    @EnableWebSecurity
    public static class StatelessRequiredConfiguration extends WebSecurityConfigurerAdapter implements Ordered
    {
        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            // @formatter:off
            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers("/stateless/**").permitAll().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            // @formatter:on
        }

        @Override
        public int getOrder()
        {
            return Ordered.HIGHEST_PRECEDENCE;
        }

    }

}
