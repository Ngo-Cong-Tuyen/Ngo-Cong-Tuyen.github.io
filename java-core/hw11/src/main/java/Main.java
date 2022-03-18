import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson=new Gson();
        ArrayList<film> list= new ArrayList<>();

        try {
            FileReader reader = new FileReader("book.json");

            Type type = new TypeToken<ArrayList<film>>(){}.getType();

            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FilmRepo repo=new FilmRepo();

        repo.show(list);

        repo.findFilmByName(list);

        repo.findFilmByCategory(list);
        System.out.println("Sort books by page number:");
        Collections.sort(list, new Comparator<film>() {
            @Override
            public int compare(film o1, film o2) {
                return o1.getPage_number()-o2.getPage_number();
            }
        });
        repo.show(list);
        System.out.println("Sort books by release year:");
        Collections.sort(list, new Comparator<film>() {
            @Override
            public int compare(film o1, film o2) {
                return o1.getRelease_year()-o2.getRelease_year();
            }
        });
        repo.show(list);
    }
}
