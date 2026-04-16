package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private List<Article> articles;
    private int lastId;

    public App() {
        scanner = new Scanner(System.in);
        articles = new ArrayList<>();
        lastId = 0;
    }

    public void run() {
        System.out.println("== 게시판 프로그램 ==");

        while (true) {
            System.out.print("명령어: ");
            String cmd = scanner.nextLine().trim();

            if (cmd.isEmpty()) {
                continue;
            }

            Rq rq = new Rq(cmd);
            String actionName = rq.getActionName();

            if (actionName.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (actionName.equals("write")) {
                writeArticle();
            } else if (actionName.equals("list")) {
                listArticles();
            } else if (actionName.equals("detail")) {
                showDetail(rq.getId());
            } else if (actionName.equals("update")) {
                updateArticle(rq.getId());
            } else if (actionName.equals("delete")) {
                deleteArticle(rq.getId());
            } else {
                System.out.println("존재하지 않는 명령어입니다.");
            }
        }

        scanner.close();
    }

    private void writeArticle() {
        System.out.print("제목: ");
        String title = scanner.nextLine().trim();

        System.out.print("내용: ");
        String content = scanner.nextLine().trim();

        int id = ++lastId;
        String regDate = LocalDate.now().toString();

        Article article = new Article(id, title, content, regDate);
        articles.add(article);

        System.out.println("=> 게시글이 등록되었습니다.");
    }

    private void listArticles() {
        if (articles.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        System.out.println("번호 | 제목 | 등록일");
        System.out.println("-------------------------");

        for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);
            System.out.printf("%d | %s | %s%n",
                    article.getId(),
                    article.getTitle(),
                    article.getRegDate());
        }
    }

    private void showDetail(int id) {
        Article article = findArticleById(id);

        if (article == null) {
            System.out.println(id + "번 게시글은 존재하지 않습니다.");
            return;
        }

        System.out.println("번호: " + article.getId());
        System.out.println("제목: " + article.getTitle());
        System.out.println("내용: " + article.getContent());
        System.out.println("등록일: " + article.getRegDate());
    }

    private void updateArticle(int id) {
        Article article = findArticleById(id);

        if (article == null) {
            System.out.println(id + "번 게시글은 존재하지 않습니다.");
            return;
        }

        System.out.print("새 제목: ");
        String newTitle = scanner.nextLine().trim();

        System.out.print("새 내용: ");
        String newContent = scanner.nextLine().trim();

        article.setTitle(newTitle);
        article.setContent(newContent);

        System.out.println("=> " + id + "번 게시글이 수정되었습니다.");
    }

    private void deleteArticle(int id) {
        Article article = findArticleById(id);

        if (article == null) {
            System.out.println(id + "번 게시글은 존재하지 않습니다.");
            return;
        }

        articles.remove(article);
        System.out.println("=> " + id + "번 게시글이 삭제되었습니다.");
    }

    private Article findArticleById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }

        return null;
    }
}