package com.nextgestion.bjlb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextgestion.bjlb.model.Joke;

public class PageContentService {

    private static ObjectMapper mapper = new ObjectMapper();

    public String getPageContent(Integer pageNumber) {
        try {
            return mapper.writeValueAsString(tempJokeCreation());
        } catch (JsonProcessingException e) {
            return "Error in the database";
        }
    }

    private Joke tempJokeCreation() {
        return new Joke("Alfred",
            "alfred@grosblagueur.com",
            Joke.Category.BAD,
            "02/07/1980",
            "C'est un schtroumpf, il court, il tombe, il se fait un bleu.");

    }

}
