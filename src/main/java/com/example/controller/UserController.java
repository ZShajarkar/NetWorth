package com.example.controller;

import com.example.dto.JwtRequest;
import com.example.dto.JwtResponse;
import com.example.dto.UserDto;
import com.example.service.JwtUserDetailsService;
import com.example.service.UserServiceImpl;
import com.example.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto) {
        try {
            userService.save(userDto);
            return ResponseEntity.ok("Successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest request) {
        try {
            authenticate(request.getUsername(), request.getPassword());

            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(request.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
