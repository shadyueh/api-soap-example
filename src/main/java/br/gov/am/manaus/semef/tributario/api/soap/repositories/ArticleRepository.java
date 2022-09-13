package br.gov.am.manaus.semef.tributario.api.soap.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.gov.am.manaus.semef.tributario.api.soap.entities.ArticleModel;

public interface ArticleRepository extends CrudRepository<ArticleModel, Long> {
    ArticleModel findByArticleId(long articleId);

    List<ArticleModel> findByTitleAndCategory(String title, String category);
}
