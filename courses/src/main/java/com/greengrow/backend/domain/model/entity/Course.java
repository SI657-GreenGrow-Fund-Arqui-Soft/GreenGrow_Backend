package com.greengrow.backend.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Represents a course entity in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course extends AbstractAggregateRoot<Course> {

    /**
     * The unique identifier for the course.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable = false)
    private String user_id;
    /**
     * The name of the course.
     */
    @Column(name="name", length =150, nullable=false)
    private String name;

    /**
     * The image associated with the course.
     */
    @Column(name="image", length =200, nullable=false)
    private String image;

    /**
     * The description of the course.
     */
    @Column(name="description", length =150, nullable=false)
    private String description;

    /**
     * The price of the course.
     */
    @Column(name="price", length =6, nullable=false)
    private String price;

    /**
     * The rating of the course.
     */
    @Column(name="rating", length =3, nullable=false)
    private String rating;

    /**
     * The duration of the course.
     */
    @Column(name="duration", length =3, nullable=false)
    private String duration;

    /**
     * The category of the course.
     */
    @Column(name="category", length = 150, nullable=false)
    private String category;

    /**
     * The date when the course is available.
     */
    @Column(name="date", length =30, nullable=false)
    private String date;

    public Course(String user_id, String name, String image, String description, String price, String rating, String duration, String category, String date) {
        this.user_id = user_id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.duration = duration;
        this.category = category;
        this.date = date;
    }
}