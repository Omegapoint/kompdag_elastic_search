package se.omegapoint.repositories;

import org.springframework.data.repository.CrudRepository;
import se.omegapoint.models.Brand;

import java.util.Set;

public interface BrandRepository extends CrudRepository<Brand, Long>{
    Set<Brand> findByDescriptionLike(String partialDescription);
}
