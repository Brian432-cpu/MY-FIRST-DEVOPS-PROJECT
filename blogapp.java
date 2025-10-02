import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Model class
class BlogPost {
    private String title;
    private String content;

    public BlogPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nContent: " + content + "\n";
    }
}

// Service / Repository
class BlogService {
    private List<BlogPost> posts = new ArrayList<>();

    public void addPost(String title, String content) {
        BlogPost post = new BlogPost(title, content);
        posts.add(post);
        System.out.println("✅ Blog post added successfully!");
    }

    public void listPosts() {
        if (posts.isEmpty()) {
            System.out.println("No blog posts yet.");
        } else {
            for (int i = 0; i < posts.size(); i++) {
                System.out.println("Post #" + (i + 1));
                System.out.println(posts.get(i));
            }
        }
    }
}

// Main Application
public class BlogApp {
    public static void main(String[] args) {
        BlogService blogService = new BlogService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Blog Application ====");
            System.out.println("1. Add a Blog Post");
            System.out.println("2. View All Blog Posts");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Content: ");
                    String content = scanner.nextLine();
                    blogService.addPost(title, content);
                    break;
                case 2:
                    blogService.listPosts();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
