package com.nextgestion.bjlb.handler.impl;

import java.util.logging.Logger;

import org.vertx.java.core.http.HttpServerRequest;

import com.nextgestion.bjlb.handler.RestHandler;
import com.nextgestion.bjlb.main.VertxServer;

public class AddingRestHandlerImpl implements RestHandler {

    private static final Logger logger = Logger.getLogger(VertxServer.GLOBAL_LOGGER);

    public AddingRestHandlerImpl() {
    }

    @Override
    public void handle(final HttpServerRequest request) {
       logger.info("youpi on est passe dans le bon handler");
        request.response().end("success");
    }

}
