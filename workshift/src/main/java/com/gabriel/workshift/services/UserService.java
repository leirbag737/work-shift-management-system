package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.user.User;
import com.gabriel.workshift.domain.user.dto.RegisterDTO;
import com.gabriel.workshift.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(RegisterDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        return this.userRepository.save(new User(data.login(), encryptedPassword, data.role()));
    }
}
