package com.tasksmng.taskmanagement.service.Implementation;

import com.tasksmng.taskmanagement.dto.LoginDto;
import com.tasksmng.taskmanagement.dto.SignUpDto;
import com.tasksmng.taskmanagement.model.User;
import com.tasksmng.taskmanagement.repository.UserRepository;
import com.tasksmng.taskmanagement.repository.UserRepositoryImpl;
import com.tasksmng.taskmanagement.response.Response;
import com.tasksmng.taskmanagement.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    public Response signUp(SignUpDto signUp) {
        if(!validateSignUp(signUp))
            return new Response(400, "Failed to validate signup");
        User user = new User();
        //ENCRYPTING
        BeanUtils.copyProperties(signUp, user);
        userRepository.save(user);
        return new Response(200, "success", user);
    }

    public Response login(LoginDto login) {
        User user = userRepository.findByUsername(login.getUsername());
        if(user == null) {
            return new Response(400, "User does not exist");
        }

        if(!user.getPassword().equals(login.getPassword())) {
            return new Response(400, "Invalid password");
        }

        return new Response(200, "Login success", null);
    }

    private boolean validateSignUp(SignUpDto signUp) {
        //TODO: validate it
        return true;
    }
}
