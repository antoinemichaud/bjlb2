package com.nextgestion.bjlb.main;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.RiakException;
import com.basho.riak.client.RiakFactory;
import com.nextgestion.bjlb.handler.RestHandler;
import com.nextgestion.bjlb.handler.StaticWebHandler;
import com.nextgestion.bjlb.handler.impl.RestHandlerImpl;
import com.nextgestion.bjlb.handler.impl.StaticWebHandlerImpl;
import com.nextgestion.bjlb.repository.JokesRepository;
import com.nextgestion.bjlb.service.PageContentService;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;

import java.util.logging.Logger;

public class VertxServer extends Verticle {

	private static final Integer PORT_NUMBER = 8182;

    private static final Logger logger = Logger.getAnonymousLogger();

    @Override
    public void start() {


        try {

            final IRiakClient riakClient = RiakFactory.pbcClient("localhost", 10017);
            final JokesRepository jokesRepository = new JokesRepository(riakClient);
            PageContentService pageContentService = new PageContentService(jokesRepository);

            StaticWebHandler staticWebHandler = new StaticWebHandlerImpl();
            RestHandler restHandler = new RestHandlerImpl(pageContentService);

            final RouteMatcher routeMatcher = new RouteMatcher();

            routeMatcher.get("/jokeContent/:page", restHandler);
            routeMatcher.getWithRegEx(".*", staticWebHandler);

            vertx.createHttpServer().requestHandler(routeMatcher).listen(PORT_NUMBER);

        } catch (RiakException e) {
            logger.severe("Impossible de se connecter à la base ");
        }

    }
}
