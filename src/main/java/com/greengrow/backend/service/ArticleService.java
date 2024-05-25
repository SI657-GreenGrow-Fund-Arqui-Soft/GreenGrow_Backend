package com.greengrow.backend.service;

import com.greengrow.backend.domain.model.entity.Article;

/**
 * Service interface for managing Article entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface ArticleService {

    /**
     * Creates a new article.
     *
     * @param article The article to be created.
     * @return The created article.
     */
    Article createArticle(Article article);
}
