package quanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<lapTrinhVien> listLapTrinhVien= new ArrayList<lapTrinhVien>();
        System.out.println("Số lập trình viên cần cho vào danh sách là:");
        int n= scanner.nextInt();
        for (int i=0;i<n;i++){
            quanLyDanhSach.addStaff(listLapTrinhVien);
        }
        System.out.println("Danh sách lập trình viên là:");
        quanLyDanhSach.showList(listLapTrinhVien);

        ArrayList<kiemChungVien> listKiemChungVien= new ArrayList<kiemChungVien>();
        System.out.println("Số kiểm chứng viên cần cho vào danh sách là:");
        int m= scanner.nextInt();
        for (int i=0;i<m;i++){
            quanLyDanhSach.addKiemChungVien(listKiemChungVien);
        }
        System.out.println("Danh sách kiểm chứng viên là:");
        quanLyDanhSach.showListKiemChungVien(listKiemChungVien);
    }
}
