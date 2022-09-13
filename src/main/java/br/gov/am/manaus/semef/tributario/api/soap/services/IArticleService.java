package br.gov.am.manaus.semef.tributario.api.soap.services;

import java.util.List;

import br.gov.am.manaus.semef.tributario.api.soap.entities.ArticleModel;

public interface IArticleService {
    List<ArticleModel> getAllArticles();

    ArticleModel getArticleById(long articleId);

    boolean addArticle(ArticleModel article);

    void updateArticle(ArticleModel article);

    void deleteArticle(ArticleModel article);
}