package com.nikhilrana.crudapidb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        /*
            Tells spring-security to use JDBC authentication with our data-source.
            And spring-security knows that it use the pre-defined schema so it automatically
            detects the tables (users and authorities)

            When we have tables as per defined by spring security then we retun JdbcUserDetailsManager

            Code:
            return new JdbcUserDetailsManager(dataSource);

         */

        // Below code is used when we have custom tables and columns. Then
        // in order to find user we have to write query so that spring-boot find users
        // from our custom tables.

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // setting the query to retrieve user by username
        // '?' replaces with data that client provices with while logging.

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        // setting the query to retrieve authorities/roles by username

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );


        return jdbcUserDetailsManager;

    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/v1/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/v1/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/employees/**").hasRole("ADMIN")
        );

        // tells to use basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable csrf because not required for stateless REST api involves GET, POST, PUT, DELETE functionalities
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }



    /*

    Code when we hard-code the data-values

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                            .username("john")
                            .password("{noop}test123")
                            .roles("EMPLOYEE")
                            .build();

        UserDetails mary = User.builder()
                            .username("mary")
                            .password("{noop}test123")
                            .roles("EMPLOYEE", "MANAGER")
                            .build();

        UserDetails susan = User.builder()
                                .username("susan")
                                .password("{noop}test123")
                                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */

}
