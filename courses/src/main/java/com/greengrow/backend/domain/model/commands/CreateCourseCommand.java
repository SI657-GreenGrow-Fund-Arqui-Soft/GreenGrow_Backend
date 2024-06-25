package com.greengrow.backend.domain.model.commands;

public record CreateCourseCommand(
        String user_id,
        String name,
        String image,
        String description,
        String price,
        String rating,
        String duration,
        String category,
        String date
) {
}
