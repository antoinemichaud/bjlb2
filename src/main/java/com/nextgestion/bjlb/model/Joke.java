package com.nextgestion.bjlb.model;

public class Joke {

    public enum Category {
        REGULAR,
        BAD
    }

    private String previousDate;

    private String nextDate;

    private String authorName;

    private String authorMail;

    private Category category;

    private String publicationDate;

    private String mainContent;

    public Joke(final String previousDate, final String nextDate, String authorName, final String authorMail,
                final Category category, final String publicationDate, final String mainContent) {
        this.previousDate = previousDate;
        this.nextDate = nextDate;
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

    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }
}
