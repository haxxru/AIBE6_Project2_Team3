package org.example.domain.article;

import org.example.util.Rq;

import java.util.List;
import java.util.Scanner;

public class ArticleController {
    private Scanner scanner;
    private ArticleService articleService;

    public ArticleController(Scanner scanner, ArticleService articleService) {
        this.scanner = scanner;
        this.articleService = articleService;
    }

    public void write() {
        System.out.print("제목: ");
        String title = scanner.nextLine().trim();

        System.out.print("내용: ");
        String content = scanner.nextLine().trim();

        Article article = articleService.write(title, content);

        System.out.println("=> " + article.getId() + "번 게시글이 등록되었습니다.");
    }

    public void list() {
        List<Article> articles = articleService.findAll();

        if (articles.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        System.out.println("번호 | 제목 | 등록일 | 조회수");
        System.out.println("-----------------------------------");

        for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);
            System.out.printf("%d | %s | %s | %d%n",
                    article.getId(),
                    article.getTitle(),
                    article.getRegDate(),
                    article.getCount());
        }
    }

    public void detail(Rq rq) {
        int id = rq.getId();

        if (id == -1) {
            System.out.println("올바른 게시글 번호를 입력해주세요.");
            return;
        }

        Article article = articleService.detail(id);

        if (article == null) {
            System.out.println(id + "번 게시글은 존재하지 않습니다.");
            return;
        }

        System.out.println("번호: " + article.getId());
        System.out.println("제목: " + article.getTitle());
        System.out.println("내용: " + article.getContent());
        System.out.println("등록일: " + article.getRegDate());
        System.out.println("조회수: " + article.getCount());
    }

    public void update(Rq rq) {
        int id = rq.getId();

        if (id == -1) {
            System.out.println("올바른 게시글 번호를 입력해주세요.");
            return;
        }

        Article article = articleService.findById(id);

        if (article == null) {
            System.out.println(id + "번 게시글은 존재하지 않습니다.");
            return;
        }

        System.out.print("새 제목: ");
        String title = scanner.nextLine().trim();

        System.out.print("새 내용: ");
        String content = scanner.nextLine().trim();

        articleService.update(id, title, content);

        System.out.println("=> " + id + "번 게시글이 수정되었습니다.");
    }

    public void delete(Rq rq) {
        int id = rq.getId();

        if (id == -1) {
            System.out.println("올바른 게시글 번호를 입력해주세요.");
            return;
        }

        boolean deleted = articleService.delete(id);

        if (!deleted) {
            System.out.println(id + "번 게시글은 존재하지 않습니다.");
            return;
        }

        System.out.println("=> " + id + "번 게시글이 삭제되었습니다.");
    }
}
