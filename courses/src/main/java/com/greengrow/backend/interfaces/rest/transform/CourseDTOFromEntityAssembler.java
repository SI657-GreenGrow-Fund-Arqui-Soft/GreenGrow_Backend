package com.greengrow.backend.interfaces.rest.transform;

import com.greengrow.backend.domain.model.entity.Course;
import com.greengrow.backend.interfaces.rest.dto.CourseDTO;

public class CourseDTOFromEntityAssembler {
    public static CourseDTO toDTOFromEntity(Course entity) {
        return new CourseDTO(
                entity.getId().toString(),
                entity.getUser_id(),
                entity.getName(),
                entity.getImage(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getRating(),
                entity.getDuration(),
                entity.getCategory(),
                entity.getDate()
        );
    }
}
