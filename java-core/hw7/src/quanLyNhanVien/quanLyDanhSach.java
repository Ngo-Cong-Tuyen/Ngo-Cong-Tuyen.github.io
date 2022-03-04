package quanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class quanLyDanhSach {
    static Scanner scanner=new Scanner(System.in);
    public static void addStaff(ArrayList<lapTrinhVien> list){
        lapTrinhVien staff= new lapTrinhVien ("112","A",18,"0123456789","a@gmail.com",10000000,15000000,7);
        System.out.println("Nhập mã nhân viên:");
        String maNhanVien= scanner.nextLine();
        staff.setMaNhanVien(maNhanVien);
        System.out.println("Họ và tên:");
        String hoTen= scanner.nextLine();
        staff.setHoTen(hoTen);
        System.out.println("Tuổi:");
        int tuoi=scanner.nextInt();
        staff.setTuoi(tuoi);
        scanner.nextLine();
        System.out.println("Số điện thoại");
        String soDienThoai= scanner.nextLine();
        staff.setSoDienThoai(soDienThoai);
        System.out.println("Email:");
        String email= scanner.nextLine();
        staff.setEmail(email);
        System.out.println("Lương cơ bản:");
        double luongCoBan= scanner.nextDouble();
        staff.setLuongCoBan(luongCoBan);
        System.out.println("Số giờ over time:");
        int soGioOverTime= scanner.nextInt();
        staff.setSoGioOverTime(soGioOverTime);
        scanner.nextLine();
        staff.setLuongThucTe(staff.Luong(soGioOverTime));
        list.add(staff);
    }
    public static void showList(ArrayList<lapTrinhVien> list){
        for (lapTrinhVien staff: list) {
            System.out.println(staff);
        }
    }

    public static void addKiemChungVien(ArrayList<kiemChungVien> list){
        kiemChungVien staff= new kiemChungVien ("112","A",18,"0123456789","a@gmail.com",10000000,15000000,7);

        System.out.println("Nhập mã nhân viên:");
        String maNhanVien= scanner.nextLine();
        staff.setMaNhanVien(maNhanVien);
        System.out.println("Họ và tên:");
        String hoTen= scanner.nextLine();
        staff.setHoTen(hoTen);
        System.out.println("Tuổi:");
        int tuoi=scanner.nextInt();
        staff.setTuoi(tuoi);
        scanner.nextLine();
        System.out.println("Số điện thoại");
        String soDienThoai= scanner.nextLine();
        staff.setSoDienThoai(soDienThoai);
        System.out.println("Email:");
        String email= scanner.nextLine();
        staff.setEmail(email);
        System.out.println("Lương cơ bản:");
        double luongCoBan= scanner.nextDouble();
        staff.setLuongCoBan(luongCoBan);
        System.out.println("Số lỗi phát hiện được:");
        int soLoiPhatHienDuoc= scanner.nextInt();
        staff.setSoLoiPhatHienDuoc(soLoiPhatHienDuoc);
        scanner.nextLine();
        staff.setLuongThucTe(staff.Luong(soLoiPhatHienDuoc));
        list.add(staff);
    }
    public static void showListKiemChungVien(ArrayList<kiemChungVien> list){
        for (kiemChungVien staff: list) {
            System.out.println(staff);
        }
    }
}
