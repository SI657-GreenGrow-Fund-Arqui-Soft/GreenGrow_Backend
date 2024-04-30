package com.greengrow.backend.service;

import com.greengrow.backend.model.Course;

/**
 * Service interface for managing Course entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface CourseService {

    /**
     * Creates a new course.
     *
     * @param course The course to be created.
     * @return The created course.
     */
    Course createCourse(Course course);
}