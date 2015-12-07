package se.omegapoint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.omegapoint.models.Article;
import se.omegapoint.models.Response;
import se.omegapoint.services.IndexService;

@Controller
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(final IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Response> index() {
        return new ResponseEntity<>(new Response(true, null, new Article()), HttpStatus.OK);
    }
}
