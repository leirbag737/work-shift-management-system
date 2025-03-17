package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.user.User;
import com.gabriel.workshift.domain.user.dto.RegisterDTO;
import com.gabriel.workshift.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationService authorizationService;


    @Transactional
    public User create(RegisterDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        return this.userRepository.save(new User(data.login(), encryptedPassword, data.role()));
    }

    public User create(RegisterDTO data, Employee employee) {

        if (this.authorizationService.loadUserByUsername(data.login()) != null) {
            throw new IllegalArgumentException("Invalid user name.");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        newUser.setEmployee(employee);

        return this.userRepository.save(newUser);
    }
}
