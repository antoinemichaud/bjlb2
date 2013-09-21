package com.nextgestion.bjlb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextgestion.bjlb.model.Joke;
import com.nextgestion.bjlb.repository.JokesRepository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.logging.Logger;

public class PageContentService {

    private static final Logger logger = Logger.getAnonymousLogger();
    private static final String BJLB_DATE_FORMAT = "yyyyMMdd";
    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern(BJLB_DATE_FORMAT);
    
    private static ObjectMapper mapper = new ObjectMapper();

    private final JokesRepository jokesRepository;

    public PageContentService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public String getPageContentWhenThereIsDate(String dateStr) {
        final DateTime requestedDateTime = DateTime.parse(dateStr, FORMATTER);
        
        if (requestedDateTime.isAfterNow()) {
        	return "fail"; 
        }
        
        Joke joke = jokesRepository.findJoke(dateStr);
        return formattedJoke(joke);
    }

    public String getPageContent(final String pageNumberStr) {
    	
    	if (pageNumberStr.matches("^\\d{8}$")) {
            return getPageContentWhenThereIsDate(pageNumberStr);
        } else {
        	final DateTime dateTime = DateTime.now();
            final int formattedIntegerDate = dateTime.getYear() * 10_000 + dateTime.getMonthOfYear() * 100 + dateTime.getDayOfMonth();
            final Joke closestJoke = findClosestJoke(Integer.toString(formattedIntegerDate));

            return formattedJoke(closestJoke);
        }
        
    }

    private Joke findClosestJoke(final String dateStr) {
        final DateTime requestedDateTime = DateTime.parse(dateStr, FORMATTER);

        Joke joke = null;
        int counter = 0;
        while (joke == null && counter < 100) {
            joke = jokesRepository.findJoke(requestedDateTime.toString(BJLB_DATE_FORMAT));
            counter++;
            requestedDateTime.minusDays(1);
        }

        return joke;
    }

    private String formattedJoke(Joke joke) {
        try {
            return mapper.writeValueAsString(joke);
        } catch (JsonProcessingException e) {
            logger.severe("Erreur lors du parsing de la blague : \n" + e.getMessage());
            return "Error in the database";
        }
    }

}
