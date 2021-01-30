package dev.kennethlindalen.rkupongoversikt.Service;

import dev.kennethlindalen.rkupongoversikt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals(userRepository.findUserByUsername(username).getUsername())){
            return new User(username, userRepository.findPasswordByUsername(username).getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
