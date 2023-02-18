package com.warehouse.demo.service;


import com.warehouse.demo.document.User;
import com.warehouse.demo.exception.UserNotFoundException;
import com.warehouse.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public com.warehouse.demo.document.User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

}
