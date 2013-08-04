package com.nextgestion.bjlb.repository;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.IRiakObject;
import com.basho.riak.client.RiakRetryFailedException;
import com.basho.riak.client.bucket.Bucket;
import com.basho.riak.client.bucket.FetchBucket;
import com.basho.riak.client.operations.FetchObject;
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

    public Joke lastJoke() {
        Joke joke = null;

        try {
            final Bucket bucket = riakClient.fetchBucket(PUBLICATIONS).execute();
            final Publication publication = bucket.fetch("20130804_regular", Publication.class).execute();
            joke = new Joke(publication.getAuthorName(), publication.getAuthorName(), Joke.Category.BAD, publication.getPublicationDate(), publication.getJokeContent());
        } catch (RiakRetryFailedException e) {
            logger.severe("Erreur lors de la communcation avec le bucket publications");
        }

        return joke;
    }

}
