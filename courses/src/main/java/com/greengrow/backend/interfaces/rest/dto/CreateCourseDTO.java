package com.greengrow.backend.interfaces.rest.dto;

public record CreateCourseDTO (
        String user_id,
        String name,
        String image,
        String description,
        String price,
        String rating,
        String duration,
        String category,
        String date
){
}
