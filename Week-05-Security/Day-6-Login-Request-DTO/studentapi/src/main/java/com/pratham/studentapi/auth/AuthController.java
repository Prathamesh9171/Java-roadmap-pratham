package com.pratham.studentapi.auth;

import com.pratham.studentapi.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.getUsername()) &&
                "admin123".equals(request.getPassword())) {

            return jwtService.generateToken(request.getUsername());
        }

        throw new RuntimeException("Invalid username or password");
    }
}