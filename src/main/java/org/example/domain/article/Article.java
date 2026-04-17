package org.example.domain.article;

public class Article {
    private int id;
    private String title;
    private String content;
    private String regDate;
    private int count;

    public Article(int id, String title, String content, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.count = 0;
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

    public int getCount() {
        return count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void increaseCount() {
        count++;
    }
}