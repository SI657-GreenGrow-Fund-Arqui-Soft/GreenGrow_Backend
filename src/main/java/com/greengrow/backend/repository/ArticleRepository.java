package com.greengrow.backend.repository;

import com.greengrow.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Article entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * Checks if an article with the specified image, title, date, and description already exists.
     *
     * @param imagen The image of the article.
     * @param titulo The title of the article.
     * @param fecha  The date of the article.
     * @param descripcion The description of the article.
     * @return True if an article with the specified attributes exists, false otherwise.
     */
    Boolean existsByImagenAndTituloAndFechaAndDescripcion(String imagen, String titulo, String fecha, String descripcion);
}
