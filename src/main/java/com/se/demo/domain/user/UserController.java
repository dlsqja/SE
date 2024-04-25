package com.se.demo.domain.user;

import com.se.demo.domain.user.dto.UserRequest;
import com.se.demo.domain.user.dto.UserResponse;
import com.se.demo.global.CustomResponse;
import com.se.demo.global.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /*
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest)
    {

        return
    }
    */

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequest userRequest)
    {

        UserResponse userResponse = userService.register(userRequest);


        if(userResponse == null){
            log.info("isnull");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("duplicate id"));
        }
        return ResponseEntity.ok().body(new CustomResponse(userResponse));

    }
}
