import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class BookRepo  {

    public  ArrayList <? extends Book>  getBook(String typeBook, ) {
        Gson gson=new Gson();
        ArrayList<? extends Book> list= new ArrayList<>();

        try {
            FileReader reader = new FileReader(typeBook);

            Type type = new TypeToken<ArrayList<? extends Book>>(){}.getType();

            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        for (Book b : list) {
//            System.out.println(b);
//        }
        return  list;
    }
}
