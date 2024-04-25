package com.se.demo.domain.diary;

import com.se.demo.global.Emotion;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary,Long> {
    Optional<List<Diary>> findAllByDateAndEmotion(LocalDate date, Emotion emotion);

    Optional<List<Diary>> findAllByDateAfterAndDateBeforeAndUserIdOrderByDate(LocalDate startDate,LocalDate endDate,Long userId);
    Optional<Diary> findByUserIdAndDate(Long userId, LocalDate localDate);

    Optional<List<Diary>> findAllByDate(LocalDate date);


}
