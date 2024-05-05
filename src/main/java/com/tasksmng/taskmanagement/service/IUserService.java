package com.tasksmng.taskmanagement.service;

import com.tasksmng.taskmanagement.dto.LoginDto;
import com.tasksmng.taskmanagement.dto.SignUpDto;
import com.tasksmng.taskmanagement.response.Response;

public interface IUserService {
    public Response signUp(SignUpDto signUp);
    public Response login(LoginDto login);
}
