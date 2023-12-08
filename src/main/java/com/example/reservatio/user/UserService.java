package com.example.reservatio.user;

import com.example.reservatio.role.Role;
import com.example.reservatio.user.dto.UserCreateDto;
import com.example.reservatio.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).get();
    }

    public void register(UserCreateDto userCreateDto) {

        User user = modelMapper.map(userCreateDto, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserCreateAT(LocalDateTime.now());

        if (user.getRole() == null) {
            user.setRole(Role.ROLE_USER);
        }

        userRepository.save(user);
    }

}
