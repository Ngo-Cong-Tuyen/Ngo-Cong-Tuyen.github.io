package quanLyNhanVien;

public class kiemChungVien extends nhanVien {
    private int soLoiPhatHienDuoc;

    public kiemChungVien(String maNhanVien, String hoTen, int tuoi, String soDienThoai, String email, double luongCoBan, double luongThucTe, int soLoiPhatHienDuoc) {
        super(maNhanVien, hoTen, tuoi, soDienThoai, email, luongCoBan, luongThucTe);
        this.soLoiPhatHienDuoc = soLoiPhatHienDuoc;
    }

    public int getSoLoiPhatHienDuoc() {
        return soLoiPhatHienDuoc;
    }

    public void setSoLoiPhatHienDuoc(int soLoiPhatHienDuoc) {
        this.soLoiPhatHienDuoc = soLoiPhatHienDuoc;
    }

    public double Luong(int soLoiPhatHienDuoc) {
        return getLuongCoBan()+soLoiPhatHienDuoc*50000;
    }

    @Override
    public String toString() {
        return getMaNhanVien() + " - " + getHoTen() + " - " + getTuoi() + " - " + getSoDienThoai() + " - " + getEmail() + " - " + getLuongCoBan() + " - " + +getLuongThucTe() + " - " + soLoiPhatHienDuoc;
    }

}
