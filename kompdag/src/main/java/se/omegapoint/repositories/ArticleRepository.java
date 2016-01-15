package se.omegapoint.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.omegapoint.models.db.Article;
import java.util.List;

@RepositoryRestResource
public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Query(
            " SELECT a FROM Article a JOIN a.suppliers as s WHERE " +
            " (LOWER(a.description) LIKE CONCAT('%',LOWER(:description),'%')) OR " +
            " (LOWER(a.color) LIKE CONCAT('%',LOWER(:color),'%')) OR " +
            " (a.weight = :weight) OR " +
            " (LOWER(s.supplierName) LIKE CONCAT('%',LOWER(:supplierName),'%'))"
    )
    List<Article> searchQuery(
            @Param("description") String description,
            @Param("color") String color,
            @Param("weight") Integer weight,
            @Param("supplierName") String supplierName, Pageable pageRequest);

}
