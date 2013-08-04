package com.nextgestion.bjlb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextgestion.bjlb.model.Joke;
import com.nextgestion.bjlb.repository.JokesRepository;

public class PageContentService {

    private static ObjectMapper mapper = new ObjectMapper();

    private final JokesRepository jokesRepository;

    public PageContentService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public String getPageContent(Integer pageNumber) {
        try {
            return mapper.writeValueAsString(jokesRepository.lastJoke());
        } catch (JsonProcessingException e) {
            return "Error in the database";
        }
    }

}
