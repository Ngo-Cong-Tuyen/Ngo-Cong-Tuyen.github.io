package Object;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class BookRepo {
    public ArrayList<Textbook> getList() throws FileNotFoundException {
        Gson gson = new Gson();
        ArrayList<Textbook> list = new ArrayList<>();

        FileReader reader = new FileReader("Textbook.json");
        Type type = new TypeToken<ArrayList<Textbook>>() {}.getType();

        list = gson.fromJson(reader, type);
        for ( Textbook b : list) {
            System.out.println(b);
        }
        return list;
    }

//    public void show(ArrayList<Textbook> list){
//        for ( Textbook b : list) {
//            System.out.println(b);
//        }
//    }
}
