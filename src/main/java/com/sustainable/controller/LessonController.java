package com.sustainable.controller;

import com.sustainable.model.Lesson;
import com.sustainable.service.LessonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "*")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // GET ALL LESSONS
    @GetMapping
    public List<Lesson> getLessons() {
        return lessonService.getAllLessons();
    }

    // ADD LESSON
    @PostMapping
    public Lesson addLesson(@RequestBody Lesson lesson) {
        return lessonService.addLesson(lesson);
    }
}