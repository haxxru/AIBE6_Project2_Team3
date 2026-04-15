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

            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (cmd.equals("write")) {
                writeArticle();
            } else if (cmd.equals("list")) {
                listArticles();
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
}