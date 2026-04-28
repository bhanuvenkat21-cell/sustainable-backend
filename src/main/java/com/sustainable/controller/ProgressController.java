package com.sustainable.controller;

import com.sustainable.model.Progress;
import com.sustainable.service.ProgressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    // GET ALL PROGRESS
    @GetMapping
    public List<Progress> getProgress() {
        return progressService.getAllProgress();
    }

    // SAVE PROGRESS
    @PostMapping
    public Progress saveProgress(@RequestBody Progress progress) {
        return progressService.saveProgress(progress);
    }
}