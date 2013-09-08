package com.nextgestion.bjlb.model;

public class Joke {

    public enum Category {
        REGULAR,
        BAD
    }

    private String previousJokeDate;

    private String nextJokeDate;

    private String authorName;

    private String authorMail;

    private Category category;

    private String publicationDate;

    private String mainContent;

    public Joke(final String previousJokeDate, final String nextJokeDate, String authorName, final String authorMail,
                final Category category, final String publicationDate, final String mainContent) {
        this.previousJokeDate = previousJokeDate;
        this.nextJokeDate = nextJokeDate;
        this.authorName = authorName;
        this.authorMail = authorMail;
        this.category = category;
        this.publicationDate = publicationDate;
        this.mainContent = mainContent;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorMail() {
        return authorMail;
    }

    public void setAuthorMail(final String authorMail) {
        this.authorMail = authorMail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(final String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(final String mainContent) {
        this.mainContent = mainContent;
    }

    public String getPreviousJokeDate() {
        return previousJokeDate;
    }

    public void setPreviousJokeDate(String previousJokeDate) {
        this.previousJokeDate = previousJokeDate;
    }

    public String getNextJokeDate() {
        return nextJokeDate;
    }

    public void setNextJokeDate(String nextJokeDate) {
        this.nextJokeDate = nextJokeDate;
    }
}
