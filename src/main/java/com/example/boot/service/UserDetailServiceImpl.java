package com.example.boot.service;


import com.example.boot.entity.User;
import com.example.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {


     UserRepository userRepository;

    @Autowired
    public void setUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with name '%s', not found", s));
        }
        return user;
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user = userService.getUserByName(username);
//       if (user == null){
//           throw  new UsernameNotFoundException(String.format("User with name '%s', not found", username));
//       }
//       return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
//            mapRolesToAuthorities(user.getRoles()));
//    }
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
//    }

}
