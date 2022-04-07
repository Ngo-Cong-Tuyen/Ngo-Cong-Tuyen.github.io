import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String randomId = NanoIdUtils.randomNanoId();
        System.out.println(randomId);

//        Random rd = new Random();
//        String number = "123456789";
//        String character = "!@#$%^&*()";
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//
//        String allCharacter = number + character + alphabet + alphabet.toUpperCase();
//
//        char [] ch = allCharacter.toCharArray();
//
//        String id = NanoIdUtils.randomNanoId(rd, ch, 5);
//
//        System.out.println(id);

        String password = "123456789";

        String encodePassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        boolean check = BCrypt.checkpw(password, encodePassword);
        System.out.println(encodePassword);
        System.out.println(check);
    }
}
