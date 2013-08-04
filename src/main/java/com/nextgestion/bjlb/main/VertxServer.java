package com.nextgestion.bjlb.main;

import com.nextgestion.bjlb.handler.RestHandler;
import com.nextgestion.bjlb.handler.StaticWebHandler;
import com.nextgestion.bjlb.handler.impl.RestHandlerImpl;
import com.nextgestion.bjlb.handler.impl.StaticWebHandlerImpl;
import com.nextgestion.bjlb.service.PageContentService;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;

public class VertxServer extends Verticle {

	private static final Integer PORT_NUMBER = 8182;
	
    @Override
    public void start() {

        PageContentService pageContentService = new PageContentService();

    	StaticWebHandler staticWebHandler = new StaticWebHandlerImpl();
    	RestHandler restHandler = new RestHandlerImpl(pageContentService);
        
        final RouteMatcher routeMatcher = new RouteMatcher();
    	
        routeMatcher.get("/jokeContent/:page", restHandler);
        routeMatcher.getWithRegEx(".*", staticWebHandler);
    	
        vertx.createHttpServer().requestHandler(routeMatcher).listen(PORT_NUMBER);
    }
}
