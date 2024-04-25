package com.se.demo.domain.user.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {

    private String nickname;
    private String id;
    private String password;

    @Builder
    UserRequest(String id,String password)
    {
        this.id=id;
        this.password=password;
        this.nickname="";
    }
}
