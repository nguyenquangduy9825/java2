package QuanLiThanhToan;

import java.util.ArrayList;

public class QuanLyCBGV {

    private ArrayList<CBGV> ds = new ArrayList<>();
    public void them(CBGV cb) {
        ds.add(cb);
    }

    public boolean xoa(String maGV) {
        for (CBGV cb : ds) {
            if (cb.getMaGV().equalsIgnoreCase(maGV)) {
                ds.remove(cb);
                return true;
            }
        }
        return false;
    }
    public void hienThi() {
        if (ds.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        for (CBGV cb : ds) {
            System.out.println(cb);
        }
    }
}