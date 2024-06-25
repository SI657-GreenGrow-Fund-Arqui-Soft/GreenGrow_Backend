package com.greengrow.backend.domain.services;

import com.greengrow.backend.domain.model.entity.Course;
import com.greengrow.backend.domain.model.queries.GetAllCoursesQuery;
import com.greengrow.backend.domain.model.queries.GetCourseByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CourseQueryService {
    List<Optional<Course>> handle(GetAllCoursesQuery query);
    Optional<Course> handle(GetCourseByIdQuery query);
}
