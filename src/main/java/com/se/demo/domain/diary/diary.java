package com.se.demo.domain.diary;

import com.se.demo.global.Emotion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    private Long userId;
    private String title;
    private String content;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Emotion emotion;

}
