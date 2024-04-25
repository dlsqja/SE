package com.se.demo.domain.diary.dto;

import com.se.demo.global.Emotion;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryRequest {

    private Long userId;
    private LocalDate date;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private Emotion emotion;
}
