import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gson gson=new Gson();
        ArrayList<Film> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader("film.json");

            Type type = new TypeToken<ArrayList<Film>>(){}.getType();

            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Film f:list) {
            System.out.println(f);
        }
    }

}
