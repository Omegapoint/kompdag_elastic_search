package se.omegapoint.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.omegapoint.models.db.Article;
import se.omegapoint.models.db.Brand;
import java.util.Collection;
import java.util.Set;

@RepositoryRestResource
public interface ArticleRepository extends CrudRepository<Article, Long> {

//    Set<Article> findByDescriptionLike(String partialDescription);
//
//    Set<Article> findByBrandIn(Collection<Brand> matchingBrands);

}
