package com.genspark.RetailOrder.Security;

import com.genspark.RetailOrder.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
//    private CustomUserDetailService userDetailService;
//
//    @Autowired
//    public SecurityConfig(CustomUserDetailService userDetailService) {
//        this.userDetailService = userDetailService;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
//    {
//        httpSecurity
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/api/users/**").permitAll()
//                .antMatchers("/api/prods/**").permitAll()
//                .antMatchers("/api/order/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        return httpSecurity.build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService()
////    {
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password("password")
////                .roles("ADMIN")
////                .build();
////        UserDetails user = User.builder()
////                .username("user")
////                .password("password")
////                .roles("ADMIN")
////                .build();
////
////        return new InMemoryUserDetailsManager(admin, user);
////    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//        throws Exception
//    {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
