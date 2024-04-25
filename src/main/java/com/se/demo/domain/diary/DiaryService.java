package com.se.demo.domain.diary;

import com.se.demo.domain.diary.dto.DiaryRequest;
import com.se.demo.domain.diary.dto.DiaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryResponse upload(DiaryRequest diaryRequest)
    {
        Diary newDiary = Diary.builder()
                .userId(diaryRequest.getUserId())
                .date(diaryRequest.getDate())
                .title(diaryRequest.getTitle())
                .content(diaryRequest.getContent())
                .emotion(diaryRequest.getEmotion())
                .build();

        diaryRepository.save(newDiary);

        Optional<List<Diary>> optionalDiaries = diaryRepository.findAllByDateAndEmotion(newDiary.getDate(),newDiary.getEmotion());

        if(optionalDiaries.isPresent())
        {
            List<Diary> diaryList = optionalDiaries.get();
            return new DiaryResponse(newDiary.getDate(),diaryList.size());
        }
        else return new DiaryResponse(newDiary.getDate(),0);
    }

    public  Map<Integer,Integer> statistic(LocalDate localDate)
    {
        Optional<List<Diary>> optionalDiaries = diaryRepository.findAllByDate(localDate);
        Integer[] totalList = new Integer[]{0,0,0,0,0,0};
        Map<Integer,Integer> listMap = new HashMap<>();
        if(optionalDiaries.isPresent())
        {
            List<Diary> diaryList = optionalDiaries.get();
            diaryList.forEach(diary -> totalList[diary.getEmotion().ordinal()]++);

            for(int i = 0;i<totalList.length;i++) {
                listMap.put(i, totalList[i]);
            }

            return listMap;
        }
        else
        {
            for(int i = 0;i<totalList.length;i++) {
                listMap.put(i, 0);
            }
            return listMap;
        }


    }
}
