package com.se.demo.domain.user;

import com.se.demo.domain.user.dto.AuthRequest;
import com.se.demo.domain.user.dto.AuthResponse;
import com.se.demo.domain.user.dto.LoginRequest;
import com.se.demo.global.response.CustomResponse;
import com.se.demo.global.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest)
    {
        return userService.login(loginRequest);
    }


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody AuthRequest authRequest)
    {

        AuthResponse authResponse = userService.register(authRequest);

        if(authResponse == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("duplicate id"));
        }
        return ResponseEntity.ok(new CustomResponse(authResponse));
    }
}
