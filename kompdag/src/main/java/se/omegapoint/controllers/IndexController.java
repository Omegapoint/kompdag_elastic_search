package se.omegapoint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.omegapoint.models.db.Article;
import se.omegapoint.models.Response;
import se.omegapoint.services.IndexService;
import java.util.Collections;
import java.util.Optional;

@RestController
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(final IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResponseEntity<Response<Article>> index() {
        Optional<Article> randomArticleOptional = indexService.getRandomArticle();
        if (randomArticleOptional.isPresent()) {
            return new ResponseEntity<>(new Response<>(true, "TEST", Collections.singleton(randomArticleOptional.get())), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Response<>(false, "TEST", Collections.emptySet()), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }


}
