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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public ResponseEntity<Object> login(LoginRequest loginRequest)
    {
        String id = loginRequest.getId();
        String password = loginRequest.getPassword();

        Optional<User> OptionalFindUser = userRepository.findById(id);
        if(OptionalFindUser.isPresent())
        {
            User findUser = OptionalFindUser.get();
            if(passwordEncoder.matches(password, findUser.getPassword()))
            {
                AuthResponse authResponse = new AuthResponse(findUser);
                return ResponseEntity.ok().body(new CustomResponse(authResponse));            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("password is not matches"));
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("not exist"));
        }
    }

    public AuthResponse register(AuthRequest authRequest)
    {
        String nickname = authRequest.getNickname();
        String id = authRequest.getId();
        String password = passwordEncoder.encode(authRequest.getPassword());

        boolean isEmpty = userRepository.findById(id).isEmpty();

        if(isEmpty)
        {
            User newUser = User.builder()
                    .nickname(nickname)
                    .id(id)
                    .password(password)
                    .build();

            User findUser = userRepository.save(newUser);

            return new AuthResponse(findUser);
        }
        else return null;


    }
}
