package com.greengrow.backend.domain.services;

import com.greengrow.backend.domain.model.commands.CreateCourseCommand;
import com.greengrow.backend.domain.model.entity.Course;

import java.util.Optional;

/**
 * Service interface for managing Course entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface CourseCommandService {

    /**
     * Creates a new course.
     *
     * @param command The course to be created.
     * @return The created course.
     */
    Optional<Course> handle(CreateCourseCommand command);
}