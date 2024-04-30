package com.greengrow.backend.controller;


import com.greengrow.backend.model.Post;
import com.greengrow.backend.repository.PostRepository;
import com.greengrow.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controller class for handling RESTful requests for posts.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@RestController
@RequestMapping("/api/green-grow/v1")
public class PostController {
    @Autowired
    private PostService postService;

    private final PostRepository postRepository;

    /**
     * Constructor for PostController.
     * @param postRepository The repository object used for accessing posts.
     */
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //URL: http://localhost:8080/api/green-grow/v1/posts
    //Method: GET
    /**
     * Method for handling GET requests for all posts.
     * @return ResponseEntity with the list of all posts and the HTTP status code.
     */
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<List<Post>>(postRepository.findAll(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/green-grow/v1/posts/filterByTag
    //Method: GET
    /**
     * Method for handling GET requests for all posts by tag.
     * @return ResponseEntity with the list of all posts and the HTTP status code.
     */
    @GetMapping("/posts/filterByTag")
    public ResponseEntity<List<Post>> getAllPostsByTag() {
        return new ResponseEntity<List<Post>>(postRepository.findAll(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/green-grow/v1/posts
    //Method: POST
    /**
     * Method for handling POST requests for creating a new post.
     * @param post The post object to be created.
     * @return ResponseEntity with the created post and the HTTP status code.
     */
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        validatePost(post);
        //existsByNameAndPrice(post);
        return new ResponseEntity<Post>(postService.createPost(post), HttpStatus.CREATED);
    }

    /**
     * Method for validating the post object.
     * @param post The post object to be validated.
     * @throws RuntimeException if the post object is not valid.
     */
    private void validatePost(Post post){
        if(post.getTitle() == null || post.getTitle().isEmpty()){
            throw new RuntimeException("El título del post es obligatorio");
        }

        if(post.getTitle().length() > 50){
            throw new RuntimeException("El título del post no puede tener más de 50 caracteres");
        }

        if(post.getAuthor() == null || post.getAuthor().isEmpty()){
            throw new RuntimeException("El autor del post es obligatorio");
        }

        if(post.getAuthor().length() > 50){
            throw new RuntimeException("El autor del post no puede tener más de 50 caracteres");
        }

        if(post.getDate() ==null) {
            throw new RuntimeException("La fecha del post es obligatoria");
        }

        if(post.getImage() ==null|| post.getImage().isEmpty()){
            throw new RuntimeException("La imagen del post es obligatoria");
        }

        if(post.getImage().length() > 200){
            throw new RuntimeException("La imagen del post no puede tener más de 200 caracteres");
        }

        if(post.getDescription() ==null|| post.getDescription().isEmpty()){
            throw new RuntimeException("La descripción del post es obligatoria");
        }

        if(post.getDescription().length() > 150) {
            throw new RuntimeException("La descripción del post no puede tener más de 150 caracteres");
        }

        if(post.getViews() < 0 || post.getViews() > 999999) {
            throw new RuntimeException("El número de vistas debe estar entre 0 y 999999");
        }

        if(post.getLikes() < 0 || post.getLikes() > 999999) {
            throw new RuntimeException("El número de likes debe estar entre 0 y 999999");
        }

        if(post.getComments() < 0 || post.getComments() > 999999) {
            throw new RuntimeException("El número de comentarios debe estar entre 0 y 999999");
        }

        if (post.getTags() != null) {
            for (String tag : post.getTags()) {
                if (tag == null || tag.isEmpty()) {
                    throw new RuntimeException("Las etiquetas de los post no pueden ser nulas o vacías");
                }
                if (tag.length() > 25) {
                    throw new RuntimeException("Cada etiqueta de post no puede tener más de 25 caracteres");
                }
            }
        }

    }
}