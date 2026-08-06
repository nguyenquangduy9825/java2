package QuanLiThanhToan;

public class Nguoi {
    private String hoTen;
    private int tuoi;
    private String queQuan;
    private String maGV;

    public Nguoi() {
    }

    public Nguoi(String hoTen, int tuoi, String queQuan, String maGV) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.maGV = maGV;
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

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    @Override
    public String toString() {
        return "Họ tên: " + hoTen +
                ", Tuổi: " + tuoi +
                ", Quê quán: " + queQuan +
                ", Mã GV: " + maGV;
    }
}