package se.omegapoint.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.omegapoint.models.db.Brand;
import java.util.Set;

@RepositoryRestResource
public interface BrandRepository extends CrudRepository<Brand, Long>{

//    Set<Brand> findByDescriptionLike(String partialDescription);

}
