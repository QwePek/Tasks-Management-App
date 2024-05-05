package com.tasksmng.taskmanagement.controller;

import com.tasksmng.taskmanagement.dto.LoginDto;
import com.tasksmng.taskmanagement.dto.SignUpDto;
import com.tasksmng.taskmanagement.response.Response;
import com.tasksmng.taskmanagement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    public Response signUp(@RequestBody SignUpDto signUpDto) {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public Response login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }
}
