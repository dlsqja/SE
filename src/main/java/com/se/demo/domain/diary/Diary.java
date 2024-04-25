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
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    private Long userId;
    private String title;
    private String content;
    private LocalDate date;
    @Enumerated(EnumType.ORDINAL)
    private Emotion emotion;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
}
