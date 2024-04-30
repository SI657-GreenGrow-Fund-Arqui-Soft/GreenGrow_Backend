package com.greengrow.backend.repository;

import com.greengrow.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Post entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Checks if a post with the specified title already exists.
     *
     * @param title The title of the post.
     * @return True if a post with the specified title exists, false otherwise.
     */
    Boolean existsByTitle(String title);
}
