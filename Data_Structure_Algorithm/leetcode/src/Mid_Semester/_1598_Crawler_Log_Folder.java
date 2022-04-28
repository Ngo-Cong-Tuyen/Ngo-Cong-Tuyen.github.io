package Mid_Semester;

public class _1598_Crawler_Log_Folder {
    public static void main(String[] args) {
        String[] logs = {"./","wz4/","../","mj2/","../","../","ik0/","il7/"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        int sum=0;
        for (String i: logs){
            if (i.equals("../")) {
                if (sum>0) sum--;
            }
            else if(!i.equals("./")) sum++;
        }
        return sum;
    }
}
