package Object;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BookRepo repo = new BookRepo();
        System.out.println("List Text book:");
        try {
            ArrayList<Textbook> listTextBook = repo.getList();
//            repo.show(listTextBook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
