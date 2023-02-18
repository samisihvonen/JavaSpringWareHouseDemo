package com.warehouse.demo.controller;

import com.warehouse.demo.dto.LoginDto;
import com.warehouse.demo.dto.SignupDto;
import com.warehouse.demo.dto.TokenDto;
import com.warehouse.demo.service.AuthService;
import com.warehouse.demo.utils.ResponseBuilder;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Operation(summary = "New User Signup")
    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody SignupDto dto) {
        TokenDto responseData = authService.signup(dto);
        return ResponseBuilder.build(HttpStatus.CREATED, null, "Successfully Signed Up", responseData);
    }

    @Operation(summary = "User Login")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto dto) {
        TokenDto data = authService.login(dto);
        return ResponseBuilder.build(HttpStatus.OK, null, "Successfully Logged In", data);
    }

    @Operation(summary = "User Logout From Single Device")
    @PostMapping("/logout")
    public ResponseEntity<Object> logout(@RequestBody TokenDto dto) {
        authService.logout(dto);
        return ResponseBuilder.build(HttpStatus.OK, null, "Successfully Logged Out", null);
    }

    @Operation(summary = "User Logout From All Devices")
    @PostMapping("/logout-all")
    public ResponseEntity<Object> logoutAll(@RequestBody TokenDto dto) {
        authService.logoutAll(dto);
        return ResponseBuilder.build(HttpStatus.OK, null, "Successfully Logged Out Of All Devices", null);
    }

    @Operation(summary = "Generate New Access Token")
    @PostMapping("/access-token")
    public ResponseEntity<Object> accessToken(@RequestBody TokenDto dto) {
        TokenDto data = authService.accessToken(dto);
        return ResponseBuilder.build(HttpStatus.OK, null, "Successfully Generated New Access Token", data);
    }

    @Operation(summary = "Generate New Refresh Token")
    @PostMapping("/refresh-token")
    public ResponseEntity<Object> refreshToken(@RequestBody TokenDto dto) {
        TokenDto data = authService.refreshToken(dto);
        return ResponseBuilder.build(HttpStatus.OK, null, "Successfully Generated New Refresh Token", data);
    }
}
