import java.util.ArrayList;
import java.util.Scanner;

public class StudentRepo {
    Scanner sc= new Scanner(System.in);
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> list= new ArrayList<>();
        list.add(new Student(1,"Tuyền",18,"HN",9.5, "12A7"));
        list.add(new Student(2,"Bắc",18,"ND",9.0, "12B11"));
        list.add(new Student(3,"Các",17,"BG",7.2, "11A1"));
        list.add(new Student(4,"Danh",18,"Sa Đéc",9.0, "12B11"));
        list.add(new Student(5,"Hòa",18,"TB",9.0, "12B11"));
        list.add(new Student(6,"Anh",16,"HB",3.5, "10B6"));
        list.add(new Student(7,"Tâm",15,"ND",8.5, "9A"));
        list.add(new Student(8,"Hà",18,"HCM",7.5, "12B11"));
        list.add(new Student(9,"Trang",14,"DakLak",4.9, "8B"));
        return list;
    }

    public void showlist(ArrayList<Student> list){
        System.out.println("Danh sách học sinh là:");
        for (Student s: list) {
            System.out.println(s);
        }
    }

    public void addNewStudent(ArrayList<Student> list){
        int id= list.size()+1;
        System.out.println("Name of new student:");
        String name= sc.nextLine();
        System.out.println("Age:");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.println("Address:");
        String address=sc.nextLine();
        System.out.println("Point:");
        double point=sc.nextDouble();
        sc.nextLine();
        System.out.println("Classroom:");
        String classroom=sc.nextLine();
        list.add(new Student(id,name,age,address,point,classroom));
    }

    public void updateStudentPoint(ArrayList<Student> list){
        System.out.println("Nhập id học sinh cần sửa điểm:");
        int id=sc.nextInt();
        for (Student s: list) {
            if (s.getId()==id) {
                System.out.println("Nhập số điểm cập nhật:");
                double point=sc.nextDouble();
                sc.nextLine();
                s.setPoint(point);
                System.out.println("Học sinh cần thay dổi điểm là:");
                System.out.println(s);
            }
        }
    }

    public void removeStudent(ArrayList<Student> list) {
        System.out.println("Nhập id học sinh cần xóa:");
        int id=sc.nextInt();
        sc.nextLine();
        list.removeIf(student -> (student.getId()==id));
    }

    public void showFollowClass(ArrayList<Student> list) {
        System.out.println("Nhập lớp:");
        String classroom=sc.nextLine();
        for (Student s:list) {
            if (s.getClassroom().equals(classroom)) {
                System.out.println(s);
            }
        }
    }
}
