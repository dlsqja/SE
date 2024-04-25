package com.se.demo.domain.diary;

import com.se.demo.domain.diary.dto.DiaryRequest;
import com.se.demo.domain.diary.dto.DiaryResponse;
import com.se.demo.domain.user.dto.AuthRequest;
import com.se.demo.domain.user.dto.AuthResponse;
import com.se.demo.global.CustomResponse;
import com.se.demo.global.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

        return ResponseEntity.ok().body(new CustomResponse(diaryResponse));
    }

    @PostMapping("/modify")
    public ResponseEntity<Object> modify(@RequestBody DiaryRequest diaryRequest)
    {
        DiaryResponse diaryResponse = diaryService.modify(diaryRequest);

        if(diaryResponse == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("not exist diary"));
        }
        return ResponseEntity.ok().body(new CustomResponse(diaryResponse));
    }

    @GetMapping("/tomorrow")
    public ResponseEntity<Object> statistic(@RequestParam("tomorrowDate") LocalDate localDate)
    {
        Map<String,Integer> resultList = diaryService.statistic(localDate);

        return ResponseEntity.ok().body(new CustomResponse(resultList));
    }


}
