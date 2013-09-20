package com.nextgestion.bjlb.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        	logger.severe("Erreur lors de la communication avec le bucket publications");
        } 
        
        // TODO 
        // creation dans le futur d'une classe utilitaire regroupant tous ces bouts de codes inutiles 
        // et pas beaux
        final Date defaultDate = new Date();
        final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        final String defaultDateStr = dateFormat.format(defaultDate);
        
        boolean isDefaultDateIsNotPresent = false;
        if (!date.equals(defaultDateStr)){
        	isDefaultDateIsNotPresent = true;
        } else {
        	isDefaultDateIsNotPresent = false;
        }
        
        return findDefaultJoke(defaultDateStr, isDefaultDateIsNotPresent);
    }
    
    /**
     * method when we don't have in database the joke of the asked day. And we are even processing
     * when we don't have the joke of today.
     * @param dateStr
     * @param isDefaultDateIsNotPresent
     * @return
     */
	public Joke findDefaultJoke(final String dateStr, final boolean isDefaultDateIsNotPresent) {

		if (isDefaultDateIsNotPresent) {
			final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date reverseDate = null;
			try {
				reverseDate = dateFormat.parse(dateStr);
			} catch (ParseException e) {
				logger.severe("Erreur lors du parsing de notre Date String en Date - findDefaultJoke method");
			}
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(reverseDate);
			calendar.add(Calendar.DATE, -1);
			final Date newDate = calendar.getTime();
			
			return findJoke(dateFormat.format(newDate));
		
		} else {
			return findJoke(dateStr);
		}

	}
    
}
