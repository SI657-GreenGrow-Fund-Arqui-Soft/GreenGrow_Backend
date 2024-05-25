package com.greengrow.backend.service.impl;

import com.greengrow.backend.domain.model.entity.Trend;
import com.greengrow.backend.domain.persistence.TrendRepository;
import com.greengrow.backend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the TrendService interface that interacts with the TrendRepository.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Service
public class TrendServiceImpl implements TrendService {

    /**
     * Repository for managing Trend entities.
     */
    @Autowired
    private TrendRepository trendRepository;

    /**
     * Creates a new trend.
     *
     * @param trend The trend to be created.
     * @return The created trend.
     */
    @Override
    public Trend createTrend(Trend trend) {
        return trendRepository.save(trend);
    }
}
