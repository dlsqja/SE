package com.se.demo.domain.user;

import com.se.demo.domain.user.dto.UserRequest;
import com.se.demo.domain.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    /*
    public UserResponse login(String id,String password)
    {

    }
*/
    public UserResponse register(UserRequest userRequest)
    {
        String nickname = userRequest.getNickname();
        String id = userRequest.getId();
        String password = userRequest.getPassword();

        Boolean isExist = userRepository.findById(id).isPresent();

        if(!isExist)
        {
            User newUser = User.builder()
                    .nickname(nickname)
                    .id(id)
                    .password(password)
                    .build();

            User findUser = userRepository.save(newUser);

            return new UserResponse(findUser);
        }
        else return null;


    }
}
