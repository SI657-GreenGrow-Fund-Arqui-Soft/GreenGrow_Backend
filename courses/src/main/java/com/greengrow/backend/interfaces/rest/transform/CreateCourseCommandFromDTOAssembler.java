package com.greengrow.backend.interfaces.rest.transform;

import com.greengrow.backend.domain.model.commands.CreateCourseCommand;
import com.greengrow.backend.interfaces.rest.dto.CreateCourseDTO;

public class CreateCourseCommandFromDTOAssembler {
    public static CreateCourseCommand toCommandFromDTO(CreateCourseDTO dto) {
        return new CreateCourseCommand(
                dto.user_id(),
                dto.name(),
                dto.image(),
                dto.description(),
                dto.price(),
                dto.rating(),
                dto.duration(),
                dto.category(),
                dto.date()
        );
    }
}