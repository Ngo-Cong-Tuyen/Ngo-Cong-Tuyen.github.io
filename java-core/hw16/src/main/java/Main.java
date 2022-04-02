import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        Random rd = new Random();
//        list.add(rd.nextInt(10));
//        list.add(rd.nextInt(10));
//        list.add(rd.nextInt(10));
//        list.add(rd.nextInt(10));
//        list.add(rd.nextInt(10));
//
//        list.removeIf(i -> i % 2==0);
//        list.forEach(i -> System.out.println(i));

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Anna", 25, "American"));
        persons.add(new Person("Robert", 19, "American"));
        persons.add(new Person("Chris", 27, "American"));
        persons.add(new Person("John", 20, "American"));

        persons.stream().filter(person -> person.getAge() < 20).forEach(person -> System.out.println(person));
    }

}
