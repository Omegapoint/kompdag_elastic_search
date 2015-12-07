package se.omegapoint.services;

import org.springframework.stereotype.Service;
import se.omegapoint.repositories.ArticleRepository;

@Service
public class IndexService {

    private final ArticleRepository articleRepository;

    public IndexService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
}
