package QuanLiThanhToan;

public class CBGV extends Nguoi {
    private double luongCung;
    private double luongThuong;
    private double tienPhat;

    public CBGV() {
    }

    public CBGV(String hoTen, int tuoi, String queQuan, String maGV,
                double luongCung, double luongThuong, double tienPhat) {

        super(hoTen, tuoi, queQuan, maGV);
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.tienPhat = tienPhat;
    }

    public double getLuongThucLinh() {
        return luongCung + luongThuong - tienPhat;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Lương cứng: " + luongCung
                + ", Lương thưởng: " + luongThuong
                + ", Tiền phạt: " + tienPhat
                + ", Lương thực lĩnh: " + getLuongThucLinh();
    }
}