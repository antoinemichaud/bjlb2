package com.nextgestion.bjlb.handler.impl;

import com.nextgestion.bjlb.handler.RestHandler;
import com.nextgestion.bjlb.service.PageContentService;
import org.vertx.java.core.MultiMap;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.HttpServerResponse;

public class RestHandlerImpl implements RestHandler {

    private static final String page = "page";

    private final PageContentService pageContentService;

    public RestHandlerImpl(final PageContentService pageContentService) {
        this.pageContentService = pageContentService;
    }

    @Override
    public void handle(final HttpServerRequest request) {

        final MultiMap params = request.params();

        final String pageNumberStr = params.get(page);

        if (pageNumberStr != null) {
            final HttpServerResponse response = request.response();
            try{
                final int pageNumber = Integer.parseInt(pageNumberStr);
                final String pageContent = pageContentService.getPageContent(pageNumber);
                response.write(pageContent);
            }
            catch (NumberFormatException e) {
                System.out.println("Probleme dans le format de l'adresse REST");
            }
            finally {
                response.close();
            }
        }
    }

}
