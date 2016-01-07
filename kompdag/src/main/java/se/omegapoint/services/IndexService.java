package se.omegapoint.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import se.omegapoint.models.Article;
import se.omegapoint.repositories.ArticleRepository;

import java.util.Optional;
import java.util.Random;

@Service
public class IndexService {

    private final ArticleRepository articleRepository;

    @Autowired
    public IndexService(final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Optional<Article> getRandomArticle() {
        Long numberOfArticles = articleRepository.count();
        if (numberOfArticles > 0) {
            Random random = new Random();
            Integer nextRandom = random.nextInt((int) Math.min(numberOfArticles, Integer.MAX_VALUE));
            return Optional.ofNullable(articleRepository.findOne(nextRandom.longValue()));
        } else {
            return Optional.<Article>empty();
        }
    }
}
