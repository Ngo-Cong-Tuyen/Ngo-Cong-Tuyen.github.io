import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{

        BookRepo repo = new BookRepo();
        ArrayList<Textbook> list = repo.getBook("Textbook.json", Textbook );
        for (Textbook b: list) {
            System.out.println(b);
        }

    }

}
