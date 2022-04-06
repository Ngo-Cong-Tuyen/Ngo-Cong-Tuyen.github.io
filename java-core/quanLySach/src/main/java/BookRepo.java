import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class BookRepo {

    public  void getBook(ArrayList<? extends Book> list) {
        Gson gson=new Gson();
        ArrayList<Textbook> list= new ArrayList<>();
        try {
            FileReader reader = new FileReader("Textbook.json");

            Type type = new TypeToken<list>(){}.getType();

            System.out.println(type);

            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  list;
    }


}
