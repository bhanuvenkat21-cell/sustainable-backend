package com.sustainable.controller;

import com.sustainable.model.Project;
import com.sustainable.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // GET ALL PROJECTS
    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }

    // ADD PROJECT
    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }
}