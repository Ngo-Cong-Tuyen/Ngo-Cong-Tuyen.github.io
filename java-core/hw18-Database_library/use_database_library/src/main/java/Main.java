import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookRepo Repo = new BookRepo();
        ArrayList<Book> list = Repo.getAllBooks();

        list.forEach(System.out::println);
        Scanner sc = new Scanner(System.in);
        System.out.println("Text a title of the book are you looking for:");
        String title = sc.nextLine();
        list.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).forEach(System.out::println);
        System.out.println("Number of the books:");
        System.out.println(list.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).count());

        System.out.println("Text a category of the book are you looking for:");
        String category = sc.nextLine();
        list.stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).forEach(System.out::println);
        System.out.println("Number of the books:");
        System.out.println(list.stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).count());

    }
}
