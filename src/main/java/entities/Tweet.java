package entities;

import uy.edu.um.prog2.adt.linkedlist.LinkedList;

public class Tweet {
    private long id;
    private String content;
    private String source;
    private boolean isRetweet;
    private int year;
    private int month;
    private int day;
    private LinkedList<Hashtag> hashtags;
    private User user;

    public Tweet() {
        this.id = id;
        this.content = content;
        this.isRetweet = isRetweet;
        this.hashtags = hashtags;
        this.user = user;
    }

    public Tweet(long id, String content, String date) {
        this.id = id;
        this.content = content;

        String[] dateArray = date.split("-");
        this.year = Integer.parseInt(dateArray[0]);
        this.month = Integer.parseInt(dateArray[1]);
        this.day = Integer.parseInt(dateArray[2]);
    }

    public Tweet(long id, String content, String source, boolean isRetweet, LinkedList<Hashtag> hashtags, User user) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.hashtags = hashtags;
        this.user = user;
    }

    public void setHashtags(String[] hashtags) {
        for (int i = 0; i < hashtags.length; i++) {
            Hashtag hashtag = new Hashtag(hashtags[i]); //hashtags[i] es de tipo String, es el texto del hashtag
            this.hashtags.add(hashtag);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LinkedList<Hashtag> getHashtags() {
        return hashtags;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
