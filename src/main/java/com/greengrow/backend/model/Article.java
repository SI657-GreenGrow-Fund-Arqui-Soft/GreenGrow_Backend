package com.greengrow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an article entity in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="articles")
public class Article {

    /**
     * The unique identifier for the article.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The image associated with the article.
     */
    @Column(name="imagen", length =250, nullable=false)
    private String imagen;

    /**
     * The title of the article.
     */
    @Column(name="titulo", length =250, nullable=false)
    private String titulo;

    /**
     * The publication date of the article.
     */
    @Column(name="fecha", length =10, nullable=false)
    private String fecha;

    /**
     * The description or content of the article.
     */
    @Column(name="descripcion", length =250, nullable=false)
    private String descripcion;

    /**
     * The link or URL associated with the article.
     */
    @Column(name="enlace", length =250, nullable=false)
    private String enlace;

}