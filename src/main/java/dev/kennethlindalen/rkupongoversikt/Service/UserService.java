package dev.kennethlindalen.rkupongoversikt.Service;

import dev.kennethlindalen.rkupongoversikt.Models.UserDocumentModel;
import dev.kennethlindalen.rkupongoversikt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
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

    public UserDocumentModel createUser(String username, String password, boolean isActive){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDocumentModel user = new UserDocumentModel(username, passwordEncoder.encode(password), isActive);

        userRepository.save(user);

        return user;
    }
}
