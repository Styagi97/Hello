/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student.student.security;

import com.student.student.Repository.AttemptsRepository;
import com.student.student.Repository.UserRepository;
import com.student.student.entity.Attempts;
import com.student.student.entity.User;
import com.student.student.services.CustomUserDetailsService;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author admin
 */
@Component public class AuthProvider implements AuthenticationProvider { 
   private static final int ATTEMPTS_LIMIT = 3; 
   @Autowired private CustomUserDetailsService userDetailsService; 
   @Autowired private PasswordEncoder passwordEncoder; 
   @Autowired private AttemptsRepository attemptsRepository; 
   @Autowired private UserRepository userRepository; 
   @Autowired private User User;
   private static final List<User> users = new ArrayList();

    public AuthProvider(User user) {
         users.add(new User("shiva", "123", "ROLE_ADMIN"));
        users.add(new User("Anjali", "234", "ROLE_ADMIN"));
    }

    
   @Override 
   public Authentication authenticate(Authentication authentication) 
   throws AuthenticationException { 
      String username = authentication.getName();
      Optional<Attempts> 
      userAttempts = attemptsRepository.findAttemptsByUsername(username); 
      if (userAttempts.isPresent()) { 
         Attempts attempts = userAttempts.get();
         attempts.setAttempts(0); attemptsRepository.save(attempts); 
      }  
      
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();
        System.out.println("credentials class: " + credentials.getClass());
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();

        Optional<User> userOptional = users.stream()
                                           .filter(u -> u.match(name, password))
                                           .findFirst();

        if (!userOptional.isPresent()) {
            throw new BadCredentialsException("Authentication failed for " + name);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.get().role));
        Authentication auth = new
                UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
        return auth;
   } 
   private void processFailedAttempts(String username, User user) { 
      Optional<Attempts> 
      userAttempts = attemptsRepository.findAttemptsByUsername(username); 
      if (userAttempts.isEmpty()) { 
         Attempts attempts = new Attempts(); 
         attempts.setUsername(username); 
         attempts.setAttempts(1); 
         attemptsRepository.save(attempts); 
      } else {
         Attempts attempts = userAttempts.get(); 
         attempts.setAttempts(attempts.getAttempts() + 1); 
         attemptsRepository.save(attempts);
      
         if (attempts.getAttempts() + 1 > 
         ATTEMPTS_LIMIT) {
            user.setAccountNonLocked(false); 
            userRepository.save(user); 
            throw new LockedException("Too many invalid attempts. Account is locked!!"); 
         } 
      }
   }
   @Override public boolean supports(Class<?> authentication) { 
      return true; 
   }
}