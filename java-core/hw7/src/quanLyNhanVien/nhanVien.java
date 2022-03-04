package quanLyNhanVien;

public class nhanVien {
    private String maNhanVien;
    private String hoTen;
    private int tuoi;
    private String soDienThoai, email;
    private double luongCoBan;
    private double luongThucTe;

    public nhanVien(String maNhanVien, String hoTen, int tuoi, String soDienThoai, String email, double luongCoBan, double luongThucTe) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.luongCoBan = luongCoBan;
        this.luongThucTe = luongThucTe;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getLuongThucTe() {
        return luongThucTe;
    }

    public void setLuongThucTe(double luongThucTe) {
        this.luongThucTe = luongThucTe;
    }

    @Override
    public String toString() {
        return maNhanVien + " - " + hoTen + " - " + tuoi + " - " + soDienThoai + " - " + email + " - " + luongCoBan + " - " + +luongThucTe + " - ";
    }
}
