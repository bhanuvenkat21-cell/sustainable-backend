package com.sustainable.service;

import com.sustainable.model.Lesson;
import com.sustainable.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}