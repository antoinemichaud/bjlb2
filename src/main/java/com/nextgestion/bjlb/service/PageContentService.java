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
        logger.info("PageContentService.getPageContent value- begin");
        try {
            final String jsonValue = mapper.writeValueAsString(jokesRepository.findJoke(date));
            logger.info("PageContentService.getPageContent value- end");

            return jsonValue;
        } catch (JsonProcessingException e) {
            logger.info("PageContentService.getPageContent value- end");
            return "Error in the database";
        }
    }

    public String getPageContent() {
        logger.info("PageContentService.getPageContent default- begin");
        final DateTime dateTime = DateTime.now();
        final int formattedIntegerDate = dateTime.getYear() * 10_000 + dateTime.getMonthOfYear() * 100 + dateTime.getDayOfMonth();

        final String pageContent = getPageContent(Integer.toString(formattedIntegerDate));
        logger.info("PageContentService.getPageContent default- end");
        return pageContent;
    }
}
