package br.gov.am.manaus.semef.tributario.api.soap.service;

import java.util.List;
import br.gov.am.manaus.semef.tributario.api.soap.models.ArticleModel;

public interface IArticleService {
    List<ArticleModel> getAllArticles();
    ArticleModel getArticleById(long articleId);
    boolean addArticle(ArticleModel article);
    void updateArticle(ArticleModel article);
    void deleteArticle(ArticleModel article);
}