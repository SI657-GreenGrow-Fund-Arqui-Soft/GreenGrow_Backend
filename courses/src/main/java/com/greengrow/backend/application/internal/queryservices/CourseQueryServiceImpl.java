package com.greengrow.backend.application.internal.queryservices;

import com.greengrow.backend.domain.model.entity.Course;
import com.greengrow.backend.domain.model.queries.GetAllCoursesQuery;
import com.greengrow.backend.domain.model.queries.GetCourseByIdQuery;
import com.greengrow.backend.domain.services.CourseQueryService;
import com.greengrow.backend.infrastructure.persistence.jpa.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseQueryServiceImpl implements CourseQueryService {

    final private CourseRepository courseRepository;

    public CourseQueryServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Optional<Course>> handle(GetAllCoursesQuery query) {

        var list = this.courseRepository.findAll();
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream()
                .map(Optional::ofNullable)
                .toList();
    }

    @Override
    public Optional<Course> handle(GetCourseByIdQuery query) {
        return this.courseRepository.findById(query.id());
    }
}
