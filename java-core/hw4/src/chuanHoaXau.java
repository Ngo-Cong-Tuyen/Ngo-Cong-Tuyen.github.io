import java.util.Scanner;

public class chuanHoaXau {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập xâu cần chuẩn hóa:");
        String s=scanner.nextLine();
        s=s.trim().toLowerCase();
        s=s.replaceAll("\\s+"," ");
        String [] temp= s.split(" ");
        s="";
        for(int i=0; i<temp.length;i++) {
            s+=String.valueOf(temp[i].charAt(0)).toUpperCase()+temp[i].substring(1);
            if (i< temp.length-1){
                s+=" ";
            }
        }
        System.out.println("Xâu sau khi chuẩn hóa là:");
        System.out.println(s);

    }
}
