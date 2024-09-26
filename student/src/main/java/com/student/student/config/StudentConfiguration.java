/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student.student.config;
 
import com.student.student.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author admin
 */
@Configuration
@EnableWebSecurity
public class StudentConfiguration extends WebSecurityConfigurerAdapter {
   
    @Bean
    public User user(){
        return new User();
    }
   @Bean 
   public PasswordEncoder passwordEncoder() { 
      return new BCryptPasswordEncoder(); 
   } 
   @Override 
   protected void configure(HttpSecurity http) throws Exception { 
      http 
      .csrf().disable()
      .authorizeRequests().antMatchers("/register**")
      .permitAll() .anyRequest().authenticated() 
      .and() 
      .formLogin() .loginPage("/login")
      .permitAll() 
      .and() 
      .logout() .invalidateHttpSession(true) 
      .clearAuthentication(true) .permitAll(); 
   }

}
