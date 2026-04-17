package org.example.domain.article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private List<Article> articles = new ArrayList<>();
    private int lastArticleId = 0;

    public Article save(String title, String content, String regDate) {
        int id = ++lastArticleId;
        Article article = new Article(id, title, content, regDate);
        articles.add(article);
        return article;
    }

    public List<Article> findAll() {
        return articles;
    }

    public Article findById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public void delete(Article article) {
        articles.remove(article);
    }
}
