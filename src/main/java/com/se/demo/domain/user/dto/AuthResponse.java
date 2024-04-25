package com.se.demo.domain.user.dto;

import com.se.demo.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthResponse {

    private Long userId;
    private String nickname;

    public AuthResponse(User user)
    {
        this.userId=user.getUserId();
        this.nickname=user.getNickname();
    }
}
