package com.nextgestion.bjlb.handler.impl;

import com.nextgestion.bjlb.handler.RestHandler;
import com.nextgestion.bjlb.service.PageContentService;
import org.vertx.java.core.MultiMap;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.HttpServerResponse;

public class AddingRestHandlerImpl implements RestHandler {

    private static final String date = "date";

    private final PageContentService pageContentService;

    public AddingRestHandlerImpl(final PageContentService pageContentService) {
        this.pageContentService = pageContentService;
    }

    @Override
    public void handle(final HttpServerRequest request) {

        final MultiMap params = request.params();
        final String pageNumberStr = params.get(date);
        final HttpServerResponse response = request.response();

    }

}
