import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Pham Van A",10,1));
        list.add(new Student("Hoang Van A",9,2));
        list.add(new Student("Nguyen Van B",5,3));
        list.add(new Student("Hoang Van C",10,4));
        list.add(new Student("Nguyen Van A",5,5));
        list.add(new Student("Hoang Van G",4,6));
        list.add(new Student("Pham Van H",10,7));
        list.add(new Student("Pham Van I",2,8));
        list.add(new Student("Pham Van G",1,9));
        list.add(new Student("Pham Van A",7,10));

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getFullName().equals(o2.getFullName())){
                    if (o1.getAge()<o2.getAge()) return 1; else return -1;
                }
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        System.out.println("#1. Sắp xếp học sinh theo fullName, neu giống fullName thì ai nhiều tuổi hơn thì đứng trước.");
        list.forEach(s -> System.out.println(s));
        System.out.println();

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge()==o2.getAge()) {
                    return o2.getGPA()-o1.getGPA();
                }
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println("#2. Sắp xếp học sinh theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần");
        list.forEach(s -> System.out.println(s));
        System.out.println();

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getFullName().substring(o1.getFullName().lastIndexOf(" ")+1).
                        equals(o2.getFullName().substring(o2.getFullName().lastIndexOf(" ")+1))){
                    if (o1.getAge()<o2.getAge()) return 1; else return -1;
                } else
                    return o1.getFullName().substring(o1.getFullName().lastIndexOf(" ")+1).
                            compareTo(o2.getFullName().substring(o2.getFullName().lastIndexOf(" ")+1));
            }
        });
        System.out.println("#3. Sắp xếp theo tên. (Ví dụ là Hoàng Văn A, thì chỉ xét A thôi)");
        list.forEach(s -> System.out.println(s));
    }
}
