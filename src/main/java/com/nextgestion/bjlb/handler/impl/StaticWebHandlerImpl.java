package com.nextgestion.bjlb.handler.impl;

import com.nextgestion.bjlb.handler.StaticWebHandler;
import org.vertx.java.core.http.HttpServerRequest;

public class StaticWebHandlerImpl implements StaticWebHandler {

    @Override
    public void handle(final HttpServerRequest req) {

        final String file = "/".equals(req.path()) ? "index.html" : req.path();
        final String fileRequiredPath = "webroot/" + file;

        req.response().sendFile(fileRequiredPath, "webroot/Kickstrap/extras/root goodies/404.html");
        req.response().close();
    }

}
