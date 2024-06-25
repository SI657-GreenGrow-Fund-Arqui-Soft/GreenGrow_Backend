package com.greengrow.backend.infrastructure.persistence.jpa.repository;

import com.greengrow.backend.domain.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Course entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * Checks if a course with the specified name and price already exists.
     *
     * @param name  The name of the course.
     * @param price The price of the course.
     * @return True if a course with the specified name and price exists, false otherwise.
     */
    Boolean existsByNameAndPrice(String name, String price);
}
