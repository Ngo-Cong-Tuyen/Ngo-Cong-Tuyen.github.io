import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FilmRepo {
    Scanner sc=new Scanner(System.in);

    public void show(ArrayList<film> list) {
        for (film f:list){
            System.out.println(f);
        }
    }
    public void findFilmByName(ArrayList<film> list){
        System.out.println("What title'film are you looking for?");
        String title=sc.nextLine();
        for (film f:list){
            if (f.getTitle().equalsIgnoreCase(title)) {
                System.out.println(f);
            }
        }
    }

    public void findFilmByCategory(ArrayList<film> list){
        System.out.println("What category are you looking for?");
        String category=sc.nextLine();
        for (film f:list){
//            String str= Arrays.toString(f.getCategory());
//            if (str.contains(category)) {
//                System.out.println(f);
//            }
            for (String str:f.getCategory()){
                if(str.equalsIgnoreCase(category)){
                    System.out.println(f);
                }
            }
        }
    }
}
