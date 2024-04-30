package com.greengrow.backend.controller;

import com.greengrow.backend.repository.TrendRepository;
import com.greengrow.backend.model.Trend;
import com.greengrow.backend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for handling RESTful requests for trends.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@RestController
@RequestMapping("/api/green-grow/v1")
public class TrendController {
    @Autowired
    private TrendService trendService;

    private final TrendRepository trendRepository;

    /**
     * Constructor for TrendController.
     * @param trendRepository The repository object used for accessing trends.
     */
    public TrendController(TrendRepository trendRepository) {
        this.trendRepository = trendRepository;
    }

    //URL: http://localhost:8080/api/green-grow/v1/trends
    //Method: GET
    /**
     * Method for handling GET requests for all trends.
     * @return ResponseEntity with the list of all trends and the HTTP status code.
     */
    @GetMapping("/trends")
    public ResponseEntity<List<Trend>> getAllTrends() {
        return new ResponseEntity<List<Trend>>(trendRepository.findAll(), HttpStatus.OK);
    }

    //Post
    //URL: http://localhost:8080/api/green-grow/v1/trends
    //Method: POST
    /**
     * Method for handling POST requests for creating a new trend.
     * @param trend The trend object to be created.
     * @return ResponseEntity with the created trend and the HTTP status code.
     */
    @PostMapping("/trends")
    public ResponseEntity<Trend> createTrend(Trend trend) {
        try {
            return new ResponseEntity<Trend>(trendService.createTrend(trend), HttpStatus.CREATED);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}