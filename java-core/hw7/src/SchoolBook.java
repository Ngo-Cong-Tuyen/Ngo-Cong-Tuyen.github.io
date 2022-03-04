public class SchoolBook  extends Library {
    private int soTrang;
    private String tinhTrang;
    private int soLuongMuon;

    public SchoolBook(int maSach, String tenSach, String nhaXuatBan, int namXuatBan, int soLuong, int soTrang, String tinhTrang, int soLuongMuon) {
        super(maSach, tenSach, nhaXuatBan, namXuatBan, soLuong);
        this.soTrang = soTrang;
        this.tinhTrang = tinhTrang;
        this.soLuongMuon = soLuongMuon;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }
}
