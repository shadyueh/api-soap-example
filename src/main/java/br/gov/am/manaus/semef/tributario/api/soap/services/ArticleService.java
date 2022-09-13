package br.gov.am.manaus.semef.tributario.api.soap.services;

import br.gov.am.manaus.semef.tributario.api.soap.entities.ArticleModel;
import br.gov.am.manaus.semef.tributario.api.soap.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleModel getArticleById(long articleId) {
        ArticleModel obj = articleRepository.findByArticleId(articleId);
        return obj;
    }

    @Override
    public List<ArticleModel> getAllArticles() {
        List<ArticleModel> list = new ArrayList<>();
        articleRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public synchronized boolean addArticle(ArticleModel article) {
        List<ArticleModel> list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
        if (list.size() > 0) {
            return false;
        } else {
            article = articleRepository.save(article);
            return true;
        }
    }

    @Override
    public void updateArticle(ArticleModel article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(ArticleModel article) {
        articleRepository.delete(article);
    }
}
