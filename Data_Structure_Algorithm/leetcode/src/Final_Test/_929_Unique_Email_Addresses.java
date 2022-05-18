package Final_Test;

import java.util.HashSet;

public class _929_Unique_Email_Addresses {
    public static void main(String[] args) {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();
        for (String str: emails) {
            StringBuilder s = new StringBuilder();
            int i=0;
            while (str.charAt(i) != '+' && str.charAt(i) != '@'){
                if (str.charAt(i) != '.') {
                    s = s.append(str.charAt(i));
                }
                i++;
            }
            while (str.charAt(i) != '@'){
                i++;
            }
            s.append(str.substring(i));
            hashSet.add(String.valueOf(s));
        }
        return hashSet.size();
    }
}
