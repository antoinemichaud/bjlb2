package com.nextgestion.bjlb.repository;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.IRiakObject;
import com.basho.riak.client.RiakRetryFailedException;
import com.basho.riak.client.bucket.Bucket;
import com.basho.riak.client.bucket.FetchBucket;
import com.basho.riak.client.operations.FetchObject;
import com.nextgestion.bjlb.model.Joke;
import com.nextgestion.bjlb.storedtype.Publication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class JokesRepository {

    public static final String PUBLICATIONS = "publications";

    private static Logger logger = Logger.getAnonymousLogger();

    private IRiakClient riakClient;

    public JokesRepository(IRiakClient riakClient) {
        this.riakClient = riakClient;
    }

    public Joke findJoke(String date) {
        Joke joke = null;

        try {
            final Bucket bucket = riakClient.fetchBucket(PUBLICATIONS).execute();
            
            final String dateStr = date + "_regular";
            final Publication publication = bucket.fetch(dateStr, Publication.class).execute();

            joke = new Joke(publication.getPreviousJokeDate(), publication.getNextJokeDate(),
                    publication.getAuthorName(), publication.getAuthorName(), Joke.Category.BAD,
                    publication.getPublicationDate(), publication.getJokeContent());

        } catch (RiakRetryFailedException e) {
            logger.severe("Erreur lors de la communcation avec le bucket publications");
        }

        return joke;
    }

}
