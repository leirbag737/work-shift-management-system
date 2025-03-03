package com.gabriel.workshift.controllers;

import com.gabriel.workshift.domain.user.User;
import com.gabriel.workshift.domain.user.dto.AuthenticationDTO;
import com.gabriel.workshift.domain.user.dto.LoginResponseDTO;
import com.gabriel.workshift.domain.user.dto.RegisterDTO;
import com.gabriel.workshift.infra.security.TokenService;
import com.gabriel.workshift.services.AuthorizationService;
import com.gabriel.workshift.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {

        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        var user = (User) auth.getPrincipal();
        var token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponseDTO(user.getRole(), token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.authorizationService.loadUserByUsername(data.login()) != null) return ResponseEntity.badRequest().build();

        this.userService.create(data);
        return ResponseEntity.ok().build();
    }
}
