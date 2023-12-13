package com.example.reservatio.user;

import com.example.reservatio.role.Role;
import com.example.reservatio.user.dto.UserCreateDto;
import com.example.reservatio.user.dto.UserFullRegisterDto;
import com.example.reservatio.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).get();
    }

    // todo add exception user not found

    public void register(UserCreateDto userCreateDto) {

        User user = modelMapper.map(userCreateDto, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserCreateAT(LocalDateTime.now());

        if (user.getRole() == null) {
            user.setRole(Role.ROLE_USER);
        }

        userRepository.save(user);
    }

    public void fullRegister(UserFullRegisterDto full,Integer id) {

        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        System.out.println(user);
        user.setFirstName(full.getFirstName());
        user.setLastName(full.getLastName());
        user.setPassportNumber(full.getPassportNumber());
        user.setPhoneNumber(full.getPhoneNumber());
        user.setUserUpdateAT(LocalDateTime.now());
        userRepository.save(user);


        // todo add exception user invalid information entered

    }

    public User one(Integer id) {
       return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User currentUser(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String username = principal.getUsername();
       return userRepository.findUserByEmail(username).orElseThrow(RuntimeException::new);
    }

}
