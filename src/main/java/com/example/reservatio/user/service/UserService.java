package com.example.reservatio.user.service;

import com.example.reservatio.role.entity.Role;
import com.example.reservatio.role.repository.RoleRepository;
import com.example.reservatio.user.entity.User;
import com.example.reservatio.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void register(String username, String password) {
        password = passwordEncoder.encode(password);
        Role defaultRole = roleRepository.findByName("USER"); // Replace roleRepository with your actual repository

        if (defaultRole == null) {
            // Create a default role if it doesn't exist in the database
            defaultRole = new Role();
            defaultRole.setName("USER");
            roleRepository.save(defaultRole);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(defaultRole); // Assigning the default role to the user

        userRepository.save(user);
    }

}
