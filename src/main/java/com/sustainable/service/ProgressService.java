package com.sustainable.service;

import com.sustainable.model.Progress;
import com.sustainable.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }
}