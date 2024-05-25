package com.greengrow.backend.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a post entity in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    /**
     * The unique identifier for the post.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the post.
     */
    @Column(name="title", length =50, nullable=false)
    private String title;

    /**
     * The author of the post.
     */
    @Column(name = "author", length =50, nullable=false)
    private String author;

    /**
     * The date when the post was published.
     */
    @Column(name = "date", length =10, nullable=false)
    private String date;

    /**
     * The image associated with the post.
     */
    @Column(name = "image", length =200, nullable=false)
    private String image;

    /**
     * The description or content of the post.
     */
    @Column(name = "description", length =150, nullable=false)
    private String description;

    /**
     * The number of views for the post.
     */
    @Column(name = "views", length =6, nullable=false)
    private int views;

    /**
     * The number of likes received by the post.
     */
    @Column(name = "likes", length =6, nullable=false)
    private int likes;

    /**
     * The number of comments on the post.
     */
    @Column(name = "comments", length =6, nullable=false)
    private int comments;

    /**
     * The list of tags associated with the post.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "tag", length =25, nullable=false)
    private List<String> tags;
}