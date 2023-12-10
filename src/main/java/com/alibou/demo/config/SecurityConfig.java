package com.alibou.demo.config;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.StringUtils;

import java.util.List;

@Configuration
// @Profile("test")
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(req ->
                        // allow method + request matcher (matcher is a part (regex) of a url)
                        /*req.requestMatchers(HttpMethod.POST, "/students")
                        // allow method + request matcher (matcher is a part (regex) of a url)
                                .permitAll()
                            .requestMatchers(HttpMethod.GET, "/subjects")
                                .permitAll()
                        // allow request matchers (matcher is a part (regex) of a url)
                            .requestMatchers("/address/**", "/chapters/**")
                                .permitAll()
                        // allow GET method for all the resources
                            .requestMatchers(HttpMethod.GET)
                                .permitAll()*/
                            req.anyRequest()
                            .authenticated()
                )
                // .formLogin(Customizer.withDefaults());
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    if ("ali".equals(username)) {
                        return User.withUsername("ali")
                                .password("1234") // lkjas!lkjkl9898__
                                .roles("USER")
                                .build();
                    }
                    if ("youssef".equals(username)) {
                        return User.withUsername("youssef")
                                .password("6789")
                                .roles("ADMIN")
                                .build();
                    }
                throw new UsernameNotFoundException("User not found");
            }
        };
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        return new InMemoryUserDetailsManager(
                User.withUsername("ali")
                        .password("1234")
                        .roles("USER")
                        .build(),
                User.withUsername("youssef")
                        .password("6789")
                        .roles("ADMIN")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
