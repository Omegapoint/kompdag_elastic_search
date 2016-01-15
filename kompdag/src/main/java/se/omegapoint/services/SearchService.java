package se.omegapoint.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.omegapoint.models.SearchForm;
import se.omegapoint.models.db.Article;
import se.omegapoint.repositories.ArticleRepository;

import java.util.List;

@Service
public class SearchService {

    private final ArticleRepository articleRepository;

    @Autowired
    public SearchService(final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> search(final SearchForm searchForm) {
        return articleRepository.searchQuery(
                searchForm.getArticleDesc()
        );
    }


}
