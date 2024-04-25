package com.se.demo.domain.user.dto;

import com.se.demo.domain.user.User;
import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse implements Serializable {

    private Long userId;
    private String nickname;

    public UserResponse(User user)
    {
        this.userId=user.getUserId();
        this.nickname=user.getNickname();
    }
}
