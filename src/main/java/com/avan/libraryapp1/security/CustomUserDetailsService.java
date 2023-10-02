package com.avan.libraryapp1.security;

import com.avan.libraryapp1.model.User;
import com.avan.libraryapp1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    Optional<User> optionalUser = userRepository.findByEmail(email);

    User user = optionalUser.orElseThrow(() -> 
        new UsernameNotFoundException("User not found with email: " + email));

    return new CustomUserDetails(user);
  }

}