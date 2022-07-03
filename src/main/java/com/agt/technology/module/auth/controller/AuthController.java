package com.agt.technology.module.auth.controller;

import com.agt.technology.module.auth.pojo.dto.LoginDTO;
import com.agt.technology.util.auth.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        System.out.println(authenticate);

        return jwtUtils.generateJwtToken(authenticate);
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/currentUserInfo")
    public String currentUserInfo() {
        return "";
    }

}
