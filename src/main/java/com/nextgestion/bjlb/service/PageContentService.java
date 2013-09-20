package com.nextgestion.bjlb.service;

import java.util.logging.Logger;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextgestion.bjlb.repository.JokesRepository;

public class PageContentService {

    private static final Logger logger = Logger.getAnonymousLogger();

    private static ObjectMapper mapper = new ObjectMapper();

    private final JokesRepository jokesRepository;

    public PageContentService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public String getPageContent(String date) {
        try {
            final String jsonValue = mapper.writeValueAsString(jokesRepository.findJoke(date));

            return jsonValue;
        } catch (JsonProcessingException e) {
            logger.severe("Erreur lors du parsing du fichier : \n" + e);
            return "Error in the database";
        }
    }

    /**
     * 
     * method we call when we don't ask with a date so it's when we want the date of today
     * @return
     */
    public String getPageContent() {
        final DateTime dateTime = DateTime.now();
        final int formattedIntegerDate = dateTime.getYear() * 10_000 + dateTime.getMonthOfYear() * 100 + dateTime.getDayOfMonth();

        final String pageContent = getPageContent(Integer.toString(formattedIntegerDate));
        return pageContent;
    }
}
