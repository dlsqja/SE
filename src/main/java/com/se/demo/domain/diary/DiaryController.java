package com.se.demo.domain.diary;

import com.se.demo.domain.diary.dto.DiaryRequest;
import com.se.demo.domain.diary.dto.DiaryResponse;
import com.se.demo.global.response.CustomResponse;
import com.se.demo.global.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diarys")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/upload")
    public ResponseEntity<Object> upload(@RequestBody DiaryRequest diaryRequest)
    {
        DiaryResponse diaryResponse = diaryService.upload(diaryRequest);

        return ResponseEntity.ok(new CustomResponse(diaryResponse));
    }

    @PostMapping("/modify")
    public ResponseEntity<Object> modify(@RequestBody DiaryRequest diaryRequest)
    {
        DiaryResponse diaryResponse = diaryService.modify(diaryRequest);

        if(diaryResponse == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("not exist diary"));
        }
        return ResponseEntity.ok(new CustomResponse(diaryResponse));
    }

    @GetMapping("/tomorrow/{tomorrowDate}")
    public ResponseEntity<Object> statistic(@PathVariable("tomorrowDate") LocalDate localDate)
    {
        Map<String,Integer> resultList = diaryService.statistic(localDate);

        return ResponseEntity.ok(new CustomResponse(resultList));
    }

    @GetMapping("/detail")
    public ResponseEntity<Object> detail(@RequestParam("date") LocalDate date,@RequestParam("userId") Long userId)
    {
        Diary diary = diaryService.detail(userId, date);

        if(diary == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("not exist diary"));
        }
        return ResponseEntity.ok(new CustomResponse(diary));

    }
    @GetMapping("/calendar")
    public ResponseEntity<Object> calendar(@RequestParam("date") LocalDate date,@RequestParam("userId") Long userId)
    {
        List<Diary> diary = diaryService.calander(userId, date);

        if(diary == null){
            return ResponseEntity.ok(new CustomResponse(new ArrayList<>()));
        }
        return ResponseEntity.ok(new CustomResponse(diary));
    }

}
