import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        StudentRepo repo= new StudentRepo();
        ArrayList<Student> list= repo.getAllStudent();
        repo.showlist(list);
        repo.addNewStudent(list);
        repo.showlist(list);
        repo.updateStudentPoint(list);
        repo.removeStudent(list);
        repo.showlist(list);
        repo.showFollowClass(list);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Sắp xếp theo tên");
        repo.showlist(list);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println("Sắp xếp theo tuổi");
        repo.showlist(list);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getPoint()-o2.getPoint())>0 ? 1:-1;
            }
        });
        System.out.println("Sắp xếp theo điểm");
        repo.showlist(list);
    }

}
