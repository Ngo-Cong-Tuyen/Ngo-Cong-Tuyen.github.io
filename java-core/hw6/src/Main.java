import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList <quanLySach> book=  new ArrayList<quanLySach>();
        Scanner scanner=new Scanner(System.in);
        book.add(new quanLySach(111,"Tập Văn Họa Kỷ Niệm Nguyễn Du","Đào Duy Anh","Văn học","Công ty TNHH Quốc Tế Mai Hà",2020));
        book.add(new quanLySach(112,"Cây Cam Ngọt Của Tôi","Nguyễn Bích Lan","Văn học","Nhà Xuất Bản Hội Nhà Văn",2022));
        book.add(new quanLySach(113, "Tâm Lý Học Về Tiền","Morgan Housel","Kinh tế","Nhà Xuất Bản Dân Trí", 2021));
        book.add(new quanLySach(114,"Payback Time","Phil Town","Kinh tế", "HappyLive",2022));
        book.add(new quanLySach(115,"Hoàng Tử Bé", "Antoine De Saint-Exupéry","Thiếu nhi","Nhà Xuất Bản Hội Nhà Văn",2019));
        book.add(new quanLySach(116,"Chú Bé Mang Pyjama Sọc","John Boyne","Thiếu nhi","Nhà Xuất Bản Hội Nhà Văn",2022));

//        int i=0;
//        System.out.println("Nhập số sách n");
//        int n= scanner.nextInt();
//        while (i<n) {
//            System.out.println("Nhập sách theo thứ tự: mã sách, tên sách, tác giả, thể loại, nhà xuất bản, năm xuất bản");
//            int maSach= scanner.nextInt();
//            String tenSach=scanner.nextLine();
//            String tacGia=scanner.nextLine();
//            String theLoai=scanner.nextLine();
//            String nhaXuatBan= scanner.nextLine();
//            int namXuatBan= scanner.nextInt();
//            quanLySach s= new quanLySach(maSach,tenSach,tacGia,theLoai,nhaXuatBan,namXuatBan);
//            book.add(s);
//            i=i+1;
//        }
        System.out.println("Tìm kiếm theo tên sách:");
        String tenSach= scanner.nextLine();
        boolean isContinue=true;
        int j=0;
        while (isContinue && j<book.size()) {
            if (book.get(j).tenSach.equalsIgnoreCase(tenSach)) {
                System.out.println(book.get(j));
                isContinue=false;
            }
            j=j+1;
        }
        if (j==book.size()) {
            System.out.println("Không tìm thấy tên sách phù hợp");
        }

        System.out.println("Tìm kiếm sách theo thể loại: 1. Văn học 2.Kinh tế 3.Thiếu nhi");
        int number= scanner.nextInt();
        switch (number) {
            case 1:
                for (int i=0; i<book.size();i++){
                    if (book.get(i).theLoai.equals("Văn học")){
                        System.out.println(book.get(i));
                    }
                }
                break;
            case 2:
                for (int i=0; i<book.size();i++){
                    if (book.get(i).theLoai.equals("Kinh tế")){
                        System.out.println(book.get(i));
                    }
                }
                break;
            case 3:
                for (int i=0; i<book.size();i++){
                    if (book.get(i).theLoai.equals("Thiếu nhi")){
                        System.out.println(book.get(i));
                    }
                }
                break;
            default:
                System.out.println("Không tìm được thể loại phù hợp");
        }
        System.out.println("Những sách xuất bản năm nay:");
        for (int i=0;i<book.size();i++) {
            if (book.get(i).namXuatBan==2022) {
                System.out.println(book.get(i));
            }
        }
    }
}
