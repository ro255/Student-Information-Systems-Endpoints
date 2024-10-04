package com.example.spring_demo.config;

import com.example.spring_demo.services.CustomUsersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private CustomUsersDetailsService usersDetailsServices;

//  private  StudentDetailsService studentDetailsService;

   protected void configure(HttpSecurity http) throws Exception{
   http.authorizeRequests()
      .dispatcherTypeMatchers(HttpMethod.valueOf("/api/v1/auth")).permitAll()
      .anyRequest().authenticated()
      .and();

  }

//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     auth.userDetailsService(studentDetailsService);
//
//
//  }

}
