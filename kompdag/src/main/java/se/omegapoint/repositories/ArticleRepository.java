package se.omegapoint.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.omegapoint.models.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
