package quanLyNhanVien;

public class lapTrinhVien extends nhanVien {
    private int soGioOverTime;

    public lapTrinhVien(String maNhanVien, String hoTen, int tuoi, String soDienThoai, String email, double luongCoBan, double luongThucTe, int soGioOverTime) {
        super(maNhanVien, hoTen, tuoi, soDienThoai, email, luongCoBan, luongThucTe);
        this.soGioOverTime = soGioOverTime;
    }

    public int getSoGioOverTime() {
        return soGioOverTime;
    }

    public void setSoGioOverTime(int soGioOverTime) {
        this.soGioOverTime = soGioOverTime;
    }

    public double Luong(int soGioOverTime) {
        return getLuongCoBan()+soGioOverTime*200000;
    }

    @Override
    public String toString() {
        return getMaNhanVien() + " - " + getHoTen() + " - " + getTuoi() + " - " + getSoDienThoai() + " - " + getEmail() + " - " + getLuongCoBan() + " - " + +getLuongThucTe() + " - " + soGioOverTime;
    }
}
