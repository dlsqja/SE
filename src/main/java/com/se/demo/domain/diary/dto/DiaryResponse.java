package com.se.demo.domain.diary.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryResponse {

    private LocalDate date;
    private int count;

    public DiaryResponse(LocalDate date, int count) {
        this.date = date;
        this.count = count;
    }
}
