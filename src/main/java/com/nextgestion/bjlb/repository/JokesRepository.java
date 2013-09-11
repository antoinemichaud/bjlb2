package com.nextgestion.bjlb.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.RiakRetryFailedException;
import com.basho.riak.client.bucket.Bucket;
import com.nextgestion.bjlb.model.Joke;
import com.nextgestion.bjlb.storedtype.Publication;

public class JokesRepository {

    public static final String PUBLICATIONS = "publications";

    private static Logger logger = Logger.getAnonymousLogger();

    private IRiakClient riakClient;

    public JokesRepository(IRiakClient riakClient) {
        this.riakClient = riakClient;
    }

    public Joke findJoke(String date) {
        try {
            final Bucket bucket = riakClient.fetchBucket(PUBLICATIONS).execute();

            final String dateStr = date + "_regular";
            final Publication publication = bucket.fetch(dateStr, Publication.class).execute();
            if (publication != null) {
            	final Joke joke = new Joke(publication.getPreviousJokeDate(), publication.getNextJokeDate(),
                        publication.getAuthorName(), publication.getAuthorName(), Joke.Category.BAD,
                        publication.getPublicationDate(), publication.getJokeContent());
            	
            	return joke;
            }
        } catch (RiakRetryFailedException e) {
        	logger.severe("Erreur lors de la communcation avec le bucket publications");
        } 
        
        // TODO 
        // creation dans le futur d'une classe utilitaire regroupant tous ces bouts de codes inutiles 
        // et pas beaux
        final Date defaultDate = new Date();
        final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        final String defaultDateStr = dateFormat.format(defaultDate);
        return findJoke(defaultDateStr);
        
    }
    
}
