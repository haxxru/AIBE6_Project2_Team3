package org.example;

public class Article {
    private int id;
    private String title;
    private String content;
    private String reqDate;
    
    public Article(int id, String title, String content, String reqDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.reqDate = reqDate;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

