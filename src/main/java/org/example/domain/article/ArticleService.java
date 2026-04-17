package org.example.domain.article;

import java.time.LocalDate;
import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article write(String title, String content) {
        String regDate = LocalDate.now().toString();
        return articleRepository.save(title, content, regDate);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    public boolean delete(int id) {
        Article article = articleRepository.findById(id);

        if (article == null) {
            return false;
        }

        articleRepository.delete(article);
        return true;
    }

    public boolean update(int id, String title, String content) {
        Article article = articleRepository.findById(id);

        if (article == null) {
            return false;
        }

        article.setTitle(title);
        article.setContent(content);
        return true;
    }

    public Article detail(int id) {
        Article article = articleRepository.findById(id);

        if (article == null) {
            return null;
        }

        article.increaseCount();
        return article;
    }
}
