package com.greengrow.backend.model;

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
    @Column(name="name", length =150, nullable=false)
    private String name;
}