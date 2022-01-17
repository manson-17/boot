package com.example.boot.service;


import com.example.boot.entity.Role;
import com.example.boot.entity.User;
import com.example.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;


@Service

public class UserDetailServiceImpl implements UserDetailsService {


     UserRepository userRepository;

    @Autowired
    public void setUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(s);
        user.getAuthorities().size();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with name '%s', not found", s));
        }
        return user;
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user = userRepository.findUserByName(username);
//       if (user == null){
//           throw  new UsernameNotFoundException(String.format("User with name '%s', not found", username));
//       }
//       return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//            mapRolesToAuthorities(user.getRoles()));
//    }
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toSet());
//    }

}
