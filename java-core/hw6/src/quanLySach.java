public class quanLySach {
    int maSach;
    String tenSach;
    String tacGia;
    String theLoai;
    String nhaXuatBan;
    int namXuatBan;

    public quanLySach(int maSach, String tenSach, String tacGia, String theLoai, String nhaXuatBan, int namXuatBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
    }

    @Override
    public String toString() {
        return maSach + " - " + tenSach + " - " + tacGia + " - " + theLoai + " - " + nhaXuatBan + " - " + namXuatBan ;
    }
}
