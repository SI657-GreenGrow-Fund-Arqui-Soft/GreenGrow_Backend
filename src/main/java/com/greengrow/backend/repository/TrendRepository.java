package com.greengrow.backend.repository;

import com.greengrow.backend.model.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Trend entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface TrendRepository extends JpaRepository<Trend, Long> {

    /**
     * Checks if a trend with the specified name already exists.
     *
     * @param name The name of the trend.
     * @return True if a trend with the specified name exists, false otherwise.
     */
    Boolean existsByName(String name);
}

