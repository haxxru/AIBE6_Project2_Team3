package org.example;

import org.example.domain.article.ArticleController;
import org.example.domain.article.ArticleRepository;
import org.example.domain.article.ArticleService;
import org.example.domain.system.SystemController;
import org.example.util.Rq;

import java.util.Scanner;

public class App {
    private Scanner scanner;
    private ArticleController articleController;
    private SystemController systemController;

    public App() {
        scanner = new Scanner(System.in);

        ArticleRepository articleRepository = new ArticleRepository();
        ArticleService articleService = new ArticleService(articleRepository);

        articleController = new ArticleController(scanner, articleService);
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 게시판 프로그램 ==");

        while (true) {
            System.out.print("명령어: ");
            String command = scanner.nextLine().trim();

            if (command.isEmpty()) {
                continue;
            }

            Rq rq = new Rq(command);
            String actionName = rq.getActionName();

            if (actionName.equals("exit")) {
                systemController.exit();
                break;
            } else if (actionName.equals("write")) {
                articleController.write();
            } else if (actionName.equals("list")) {
                articleController.list();
            } else if (actionName.equals("detail")) {
                articleController.detail(rq);
            } else if (actionName.equals("update")) {
                articleController.update(rq);
            } else if (actionName.equals("delete")) {
                articleController.delete(rq);
            } else {
                System.out.println("존재하지 않는 명령어입니다.");
            }
        }

        scanner.close();
    }
}