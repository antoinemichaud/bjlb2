package com.nextgestion.bjlb.storedtype;

public class Publication {

    private String previousJokeDate;

    private String nextJokeDate;

    private String authorName;

    private String authorMail;

    private String publicationDate;

    private String category;

    private String jokeContent;

    public Publication() {
    }

    public Publication(String previousJokeDate, String nextJokeDate, String authorName, String authorMail, String publicationDate, String category, String jokeContent) {
        this.previousJokeDate = previousJokeDate;
        this.nextJokeDate = nextJokeDate;
        this.authorName = authorName;
        this.authorMail = authorMail;
        this.publicationDate = publicationDate;
        this.category = category;
        this.jokeContent = jokeContent;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorMail() {
        return authorMail;
    }

    public void setAuthorMail(String authorMail) {
        this.authorMail = authorMail;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJokeContent() {
        return jokeContent;
    }

    public void setJokeContent(String jokeContent) {
        this.jokeContent = jokeContent;
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
