package se.omegapoint.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.omegapoint.models.db.Article;
import se.omegapoint.models.db.Brand;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RepositoryRestResource
public interface ArticleRepository extends CrudRepository<Article, Long> {


    @Query("SELECT a FROM Article a WHERE LOWER(a.description) LIKE CONCAT('%',LOWER(:description),'%')")
    List<Article> searchQuery(@Param("description") String description);

}
