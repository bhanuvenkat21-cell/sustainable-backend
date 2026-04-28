package com.sustainable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sustainable.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}