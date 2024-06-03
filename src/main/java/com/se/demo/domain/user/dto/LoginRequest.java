package com.se.demo.domain.user.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {
    private String id;
    private String password;
}
