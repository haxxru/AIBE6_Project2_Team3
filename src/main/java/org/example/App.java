import org.example.Article;import java.util.ArrayList;
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
            }
        }

        scanner.close();
    }
}