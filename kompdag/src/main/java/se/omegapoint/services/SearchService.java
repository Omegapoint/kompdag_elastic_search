package se.omegapoint.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.omegapoint.exceptions.NoMatchException;
import se.omegapoint.models.db.Article;
import se.omegapoint.models.db.Brand;
import se.omegapoint.repositories.ArticleRepository;
import se.omegapoint.repositories.BrandRepository;

import java.util.Collections;
import java.util.Set;

@Service
public class SearchService {

    private final ArticleRepository articleRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public SearchService(final ArticleRepository articleRepository, BrandRepository brandRepository) {
        this.articleRepository = articleRepository;
        this.brandRepository = brandRepository;
    }

    public Set<Article> findByPartialDescription(final String partialDescription) {
        return articleRepository.findByDescriptionLike(partialDescription);
    }

    public Set<Article> findByPartialBrandDescription(final String partialDescription) throws NoMatchException {
        Set<Brand> matchingBrands = brandRepository.findByDescriptionLike(partialDescription);
        if (matchingBrands == null || matchingBrands.isEmpty()) {
            throw new NoMatchException(String.format("Could not find a brand matching %s", partialDescription));
        }
        Set<Article> matchingArticles = articleRepository.findByBrandIn(matchingBrands);
        if (matchingArticles == null) {
            matchingArticles = Collections.emptySet();
        }
        return matchingArticles;
    }
}
