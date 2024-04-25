package com.se.demo.domain.user.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthRequest {

    private String nickname;
    private String id;
    private String password;

    @Builder
    AuthRequest(String id, String password)
    {
        this.id=id;
        this.password=password;
        this.nickname="";
    }
}
