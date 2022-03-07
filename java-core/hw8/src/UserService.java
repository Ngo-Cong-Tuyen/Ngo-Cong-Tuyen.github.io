import java.util.ArrayList;

public class UserService {

    public ArrayList<User> getListUser() {
        ArrayList<User> listUser = new ArrayList<>();

        User u1 = new User(1, "Ngoc", "123");
        User u2 = new User(2, "Linh", "12345");

        listUser.add(u1);
        listUser.add(u2);
        listUser.add(new User(3, "Huy", "123"));
        listUser.add(new User(4, "Linh", "123"));
        listUser.add(new User(5, "Huy", "123"));

        return listUser;
    }

    public void show(ArrayList<User> list){
        for (User u: list) {
            System.out.println(u);
        }
    }

    public void checkUser(ArrayList<User> list, String usename, String password){
        boolean check=false;
        for (User u:list) {
            if (u.getUsename().equals(usename) && u.getPassword().equals(password)) {
                check=true;
            }
        }

        if (check) {
            System.out.println("Dang nhap thanh cong");
        } else {
            System.out.println("Moi thu lai");
        }
    }
}

