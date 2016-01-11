package se.omegapoint.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.omegapoint.models.db.Article;

@RepositoryRestResource
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
