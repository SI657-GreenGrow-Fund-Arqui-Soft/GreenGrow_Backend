package com.greengrow.backend.service.impl;

import com.greengrow.backend.domain.model.entity.Post;
import com.greengrow.backend.domain.persistence.PostRepository;
import com.greengrow.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the PostService interface that interacts with the PostRepository.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Service
public class PostServiceImpl implements PostService {

    /**
     * Repository for managing Post entities.
     */
    @Autowired
    private PostRepository postRepository;

    /**
     * Creates a new post.
     *
     * @param post The post to be created.
     * @return The created post.
     */
    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
