package com.nextgestion.bjlb.storedtype;

public class PendingPublication {

	private long id;
	
    private String authorName;

    private String authorMail;

    private String jokeContent;

    public PendingPublication() {
    }

    public PendingPublication(final long id, final String authorName, final String authorMail, final String jokeContent) {
    	this.id = id;
        this.authorName = authorName;
        this.authorMail = authorMail;
        this.jokeContent = jokeContent;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

    public String getJokeContent() {
        return jokeContent;
    }

    public void setJokeContent(String jokeContent) {
        this.jokeContent = jokeContent;
    }

}
