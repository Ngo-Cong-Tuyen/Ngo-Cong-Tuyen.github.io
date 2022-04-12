import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class BookRepo {

    public  ArrayList<Textbook> getListTextbook(){
        Gson gson=new Gson();
        ArrayList<Textbook> list= new ArrayList<>();
        try {
            FileReader reader = new FileReader("Textbook.json");

            Type type = new TypeToken<ArrayList<Textbook>>(){}.getType();

            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  list;
    }

    public  ArrayList<E_book> getListE_book(){
        Gson gson=new Gson();
        ArrayList<E_book> list= new ArrayList<>();
        try {
            FileReader reader = new FileReader("E_book.json");

            Type type = new TypeToken<ArrayList<E_book>>(){}.getType();

            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addNewTextbook(ArrayList<Textbook> list){
        Textbook b = new Textbook();
        b.setId(21);
        b.setAmount(21);
        b.setPage_number(21);
        b.setAuthor("Nam Cao");
        b.setCategory("Literature");
        b.setDescription("A book give a ambience vietnamese war in a countryside");
        b.setPublishing_company("NXB van hoc Viet Nam");
        b.setPublishing_year(2000);
        b.setTitle("Lao Hac");

        list.add(b);
    }

    public void addNewE_book(ArrayList<E_book> list){
        E_book b = new E_book();
        b.setId(21);
        b.setCapacity("50M");
        b.setTotal_downloads(21);
        b.setAuthor("Nam Cao");
        b.setCategory("Literature");
        b.setDescription("A book give a ambience vietnamese war in a countryside");
        b.setPublishing_company("NXB van hoc Viet Nam");
        b.setPublishing_year(2000);
        b.setTitle("Lao Hac");

        list.add(b);
    }

    public void findBookByName(ArrayList<Textbook> listT,ArrayList<E_book> listE, String title){
        System.out.println("List of books what have name is "+ title);
        listE.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).forEach(System.out::println);
        listT.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).forEach(System.out::println);
    }

    public void findBookById(ArrayList<Textbook> listT,ArrayList<E_book> listE, int id){
        System.out.println("List of books what have id = "+ id);
        listE.stream().filter(book -> book.getId() ==id).forEach(System.out::println);
        listT.stream().filter(book -> book.getId() ==id).forEach(System.out::println);
    }

    public void deleteBook(ArrayList<Textbook> listT,ArrayList<E_book> listE,int id){
        listT.removeIf(b -> b.getId()==id);
        listE.removeIf(b -> b.getId()==id);
    }

    public void updateBook(ArrayList<Textbook> listT,ArrayList<E_book> listE, int id){
        listT.stream().filter(book -> book.getId()==id).forEach(book -> book.setAmount(11));
        listE.stream().filter(book -> book.getId()==id).forEach(book -> book.setTotal_downloads(11));
    }

}
