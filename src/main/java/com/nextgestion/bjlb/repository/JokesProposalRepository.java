package com.nextgestion.bjlb.repository;

import com.basho.riak.client.IRiakClient;
import com.nextgestion.bjlb.model.Joke;

public class JokesProposalRepository {

    public static final String PUBLICATIONS = "pending_publications";

    private IRiakClient riakClient;

    public JokesProposalRepository(IRiakClient riakClient) {
        this.riakClient = riakClient;
    }

    public Joke addJoke(String requestedDate) {
        return null;
    }
}
