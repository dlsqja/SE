package com.se.demo.domain.diary;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diarys")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

}
