package com.greengrow.backend.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a trend entity in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="trends")
public class Trend {

    /**
     * The unique identifier for the trend.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the trend.
     */
    @Column(name="title", length =150, nullable = false)
    private String title;

    @Column(name="image", length =150, nullable = false)
    private String image;

    @Column(name="date", length =150, nullable = false)
    private String date;

    @Column(name="description", length =550, nullable = false)
    private String description;

    @Column(name="link", length =150, nullable = false)
    private String link;
}