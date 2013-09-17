package com.nextgestion.bjlb.handler.impl;

import com.nextgestion.bjlb.handler.RestHandler;
import com.nextgestion.bjlb.service.PageContentService;
import org.vertx.java.core.MultiMap;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.HttpServerResponse;

public class NavigationRestHandlerImpl implements RestHandler {

    private static final String date = "date";

    private final PageContentService pageContentService;

    public NavigationRestHandlerImpl(final PageContentService pageContentService) {
        this.pageContentService = pageContentService;
    }

    @Override
    public void handle(final HttpServerRequest request) {

        final MultiMap params = request.params();
        final String pageNumberStr = params.get(date);
        final HttpServerResponse response = request.response();

        if (pageNumberStr.matches("^\\d{8}$")) {
            final String pageContent = pageContentService.getPageContent(pageNumberStr);
            response.end(pageContent);
        } else {
            final String pageContent = pageContentService.getPageContent();
            response.end(pageContent);
        }
    }

}
