package se.omegapoint.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import se.omegapoint.models.Article;

@RepositoryRestResource
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
