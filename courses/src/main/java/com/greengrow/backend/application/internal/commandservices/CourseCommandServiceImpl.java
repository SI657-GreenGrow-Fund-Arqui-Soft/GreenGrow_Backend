package com.greengrow.backend.application.internal.commandservices;

import com.greengrow.backend.application.internal.outboundservices.CoursePublisherService;
import com.greengrow.backend.domain.model.commands.CreateCourseCommand;
import com.greengrow.backend.domain.model.entity.Course;
import com.greengrow.backend.domain.services.CourseCommandService;
import com.greengrow.backend.infrastructure.persistence.jpa.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the CourseService interface that interacts with the CourseRepository.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Service
public class CourseCommandServiceImpl implements CourseCommandService {
    final private CoursePublisherService coursePublisherService;
    final private CourseRepository courseRepository;

    public CourseCommandServiceImpl(CoursePublisherService coursePublisherService, CourseRepository courseRepository) {
        this.coursePublisherService = coursePublisherService;
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> handle(CreateCourseCommand command) {

        boolean userExists = this.coursePublisherService.existsUser(command.user_id());
        if (!userExists) {
            throw new RuntimeException("User does not exist");
        }
        Course course = new Course(
                command.user_id(),
                command.name(),
                command.image(),
                command.description(),
                command.price(),
                command.rating(),
                command.rating(),
                command.duration(),
                command.date()
        );
        courseRepository.save(course);
        return Optional.of(course);
    }
}
