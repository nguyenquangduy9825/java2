package QuanLiThanhToan;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuanLyCBGV ql = new QuanLyCBGV();

        int chon;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm giảng viên");
            System.out.println("2. Xóa theo mã");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {

                case 1:
                    System.out.print("Họ tên: ");
                    String ten = sc.nextLine();

                    System.out.print("Tuổi: ");
                    int tuoi = Integer.parseInt(sc.nextLine());

                    System.out.print("Quê quán: ");
                    String que = sc.nextLine();

                    System.out.print("Mã GV: ");
                    String ma = sc.nextLine();

                    System.out.print("Lương cứng: ");
                    double lc = Double.parseDouble(sc.nextLine());

                    System.out.print("Lương thưởng: ");
                    double lt = Double.parseDouble(sc.nextLine());

                    System.out.print("Tiền phạt: ");
                    double tp = Double.parseDouble(sc.nextLine());

                    CBGV cb = new CBGV(ten, tuoi, que, ma, lc, lt, tp);
                    ql.them(cb);

                    System.out.println("Đã thêm!");
                    break;

                case 2:
                    System.out.print("Nhập mã GV cần xóa: ");
                    String xoa = sc.nextLine();

                    if (ql.xoa(xoa))
                        System.out.println("Xóa thành công!");
                    else
                        System.out.println("Không tìm thấy mã.");
                    break;

                case 3:
                    ql.hienThi();
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (chon != 0);
    }
}