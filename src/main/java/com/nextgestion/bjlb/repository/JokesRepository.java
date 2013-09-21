package com.nextgestion.bjlb.repository;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.RiakRetryFailedException;
import com.basho.riak.client.bucket.Bucket;
import com.nextgestion.bjlb.model.Joke;
import com.nextgestion.bjlb.storedtype.Publication;

import java.util.logging.Logger;

public class JokesRepository {

    public static final String PUBLICATIONS = "publications";

    private static Logger logger = Logger.getAnonymousLogger();

    private IRiakClient riakClient;

    public JokesRepository(IRiakClient riakClient) {
        this.riakClient = riakClient;
    }

    public Joke findJoke(String requestedDate) {
        Joke joke = null;

        try {
            final Bucket bucket = riakClient.fetchBucket(PUBLICATIONS).execute();

            final String dateStr = requestedDate + "_regular";
            final Publication publication = bucket.fetch(dateStr, Publication.class).execute();

            if (publication != null) {
                joke = new Joke(publication.getPreviousJokeDate(), publication.getNextJokeDate(),
                        publication.getAuthorName(), publication.getAuthorName(), Joke.Category.BAD,
                        publication.getPublicationDate(), publication.getJokeContent());

            }
        } catch (RiakRetryFailedException e) {
            logger.severe("Erreur lors de la communication avec le bucket publications");
        }

        return joke;
    }
}
