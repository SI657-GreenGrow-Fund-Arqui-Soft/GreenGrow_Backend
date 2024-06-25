package com.greengrow.backend.interfaces.rest;

import com.greengrow.backend.domain.model.entity.Course;
import com.greengrow.backend.domain.model.queries.GetAllCoursesQuery;
import com.greengrow.backend.domain.model.queries.GetCourseByIdQuery;
import com.greengrow.backend.domain.services.CourseQueryService;
import com.greengrow.backend.domain.services.CourseCommandService;
import com.greengrow.backend.interfaces.rest.dto.CourseDTO;
import com.greengrow.backend.interfaces.rest.dto.CreateCourseDTO;
import com.greengrow.backend.interfaces.rest.transform.CourseDTOFromEntityAssembler;
import com.greengrow.backend.interfaces.rest.transform.CreateCourseCommandFromDTOAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

/**
 * Controller class for handling RESTful requests for courses.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@RestController
@RequestMapping("/api/green-grow/v1")
public class CoursesController {

    private final CourseCommandService courseCommandService;
    private final CourseQueryService courseQueryService;

    public CoursesController(CourseCommandService courseCommandService, CourseQueryService courseQueryService) {
        this.courseCommandService = courseCommandService;
        this.courseQueryService = courseQueryService;
    }

    /**
     * Constructor for CourseController.
     * @param courseRepository The repository object used for accessing courses.
     */

    //URL: http://localhost:8080/api/green-grow/v1/courses
    //Method: GET
    /**
     * Method for handling GET requests for all courses.
     * @return ResponseEntity with the list of all courses and the HTTP status code.
     */
    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        var getAllCoursesCommand = new GetAllCoursesQuery();
        var courses = courseQueryService.handle(getAllCoursesCommand);
        List<CourseDTO> courseDTOList = courses
                .stream()
                .flatMap(optional -> optional.map(Stream::of).orElseGet(Stream::empty))
                .map(CourseDTOFromEntityAssembler::toDTOFromEntity)
                .toList();
        return new ResponseEntity<List<CourseDTO>>(courseDTOList, HttpStatus.OK);
    }

    //GetById
    //URL: http://localhost:8080/api/green-grow/v1/courses/{id}
    //Method: GET


    /**
     * Method for handling GET requests for a course by id.
     * @param id The id of the course to be returned.
     * @return ResponseEntity with the course and the HTTP status code.
     */
    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> getCourseById(Long id) {
        var getCourseByIdCommand = new GetCourseByIdQuery(id);
        var course = courseQueryService.handle(getCourseByIdCommand);
        var courseDTO = CourseDTOFromEntityAssembler.toDTOFromEntity(course.get());
        return new ResponseEntity<CourseDTO>(courseDTO, HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/green-grow/v1/courses
    //Method: POST
    /**
     * Method for handling POST requests for creating a new course.
     * @param courseDTO The course object to be created.
     * @return ResponseEntity with the created course and the HTTP status code.
     */
    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CreateCourseDTO courseDTO) {
        var createCourseCommand = CreateCourseCommandFromDTOAssembler.toCommandFromDTO(courseDTO);
        var course = courseCommandService.handle(createCourseCommand);
        var response = CourseDTOFromEntityAssembler.toDTOFromEntity(course.get());
        return new ResponseEntity<CourseDTO>(response, HttpStatus.CREATED);
    }

    /**
     * Method for validating the course object.
     * @param course The course object to be validated.
     * @throws RuntimeException if the course object is not valid.
     */
    private void validateCourse(Course course){
        if(course.getName() == null || course.getName().isEmpty()){
            throw new RuntimeException("El nombre del curso es obligatorio");
        }

        if(course.getName().length() > 150){
            throw new RuntimeException("El nombre del curso no puede tener más de 50 caracteres");
        }

        if(course.getImage() == null || course.getImage().isEmpty()){
            throw new RuntimeException("El enlace de la imagen del curso es obligatoria");
        }

        if(course.getImage().length() > 200){
            throw new RuntimeException("El enlace de la imagen del curso no puede tener más de 200 caracteres");
        }

        if(course.getDescription() == null || course.getDescription().isEmpty()){
            throw new RuntimeException("La descripción del curso es obligatoria");
        }

        if(course.getDescription().length() > 150){
            throw new RuntimeException("La descripción del curso no puede tener más de 100 caracteres");
        }

        if(course.getPrice() == null || course.getPrice().isEmpty()){
            throw new RuntimeException("El precio del curso es obligatorio");
        }

        if(course.getPrice().length() > 6){
            throw new RuntimeException("El precio del curso no puede tener más de 6 caracteres");
        }

        if(course.getRating() == null || course.getRating().isEmpty()){
            throw new RuntimeException("El rating del curso es obligatorio");
        }

        if(course.getRating().length() > 3){
            throw new RuntimeException("El rating del curso no puede tener más de 3 caracteres");
        }

        if(course.getDuration() == null || course.getDuration().isEmpty()){
            throw new RuntimeException("La duración del curso es obligatoria");
        }

        if(course.getDuration().length() > 3) {
            throw new RuntimeException("La duración del curso no puede tener más de 3 caracteres");
        }

        if(course.getCategory() == null || course.getCategory().isEmpty()){
            throw new RuntimeException("La categoría del curso es obligatoria");
        }

        if(course.getCategory().length() > 150){
            throw new RuntimeException("La categoría del curso no puede tener más de 150 caracteres");
        }

        if(course.getDate() == null || course.getDate().isEmpty()){
            throw new RuntimeException("La fecha del curso es obligatoria");
        }

        if(course.getDate().length() > 30){
            throw new RuntimeException("La fecha del curso no puede tener más de 30 caracteres");
        }


    }
}