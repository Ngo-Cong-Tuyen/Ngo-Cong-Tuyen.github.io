import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        BookRepo repo = new BookRepo();
        System.out.println("List textbook:");
        ArrayList<Textbook> listTextbook = repo.getListTextbook();
        listTextbook.forEach(System.out::println);

        System.out.println("List e-book:");
        ArrayList<E_book> listE_book = repo.getListE_book();
        listE_book.forEach(System.out::println);

        repo.addNewTextbook(listTextbook);
        repo.addNewE_book(listE_book);
        System.out.println("List textbook after update:");
        listTextbook.forEach(System.out::println);
        System.out.println("List e-book after update:");
        listE_book.forEach(System.out::println);

        System.out.println("Text a title are you looking for:");
        String title = sc.nextLine();
        repo.findBookByName(listTextbook,listE_book,title);

        System.out.println("Text a id_book are you looking for:");
        int id = sc.nextInt();
        repo.findBookById(listTextbook,listE_book,id);

        System.out.println("Text a id book you want delete:");
        id = sc.nextInt();
        repo.deleteBook(listTextbook,listE_book,id);
        System.out.println("List textbook after deleted:");
        listTextbook.forEach(System.out::println);
        System.out.println("List e-book after deleted:");
        listE_book.forEach(System.out::println);

        System.out.println("Text a id book you want update:");
        id = sc.nextInt();
        repo.updateBook(listTextbook,listE_book,id);
        System.out.println("List textbook after update:");
        listTextbook.forEach(System.out::println);
        System.out.println("List e-book after update:");
        listE_book.forEach(System.out::println);
    }

}
