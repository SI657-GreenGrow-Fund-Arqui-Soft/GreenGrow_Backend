package com.greengrow.backend.service;

import com.greengrow.backend.domain.model.entity.Trend;

/**
 * Service interface for managing Trend entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface TrendService {

    /**
     * Creates a new trend.
     *
     * @param trend The trend to be created.
     * @return The created trend.
     */
    Trend createTrend(Trend trend);
}
