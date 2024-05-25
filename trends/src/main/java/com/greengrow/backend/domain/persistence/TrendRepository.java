package com.greengrow.backend.domain.persistence;

import com.greengrow.backend.domain.model.entity.Trend;
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
     * @param title The title of the trend.
     * @param image The image of the trend.
     * @param date The date of the trend.
     * @param description The description of the trend.
     * @param link The name link the trend.
     *
     * @return True if a trend with the specified attributes exists, false otherwise.
     */
    Boolean existsByTitleAndImageAndDateAndDescriptionAndLink(String title,String image,String date,String description,String link);
}

