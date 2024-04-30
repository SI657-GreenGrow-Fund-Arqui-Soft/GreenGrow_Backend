package com.greengrow.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the GreenGrow backend application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@SpringBootApplication
public class BackendApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args Command line arguments (unused in this application).
	 */
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}