import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class XepLoai extends JFrame {

    private JPanel mainPanel;

    private JTextField txtHoTen;
    private JTextField txtSoHocPhan;
    private JTextField txtCC;
    private JTextField txtGK;
    private JTextField txtNgaySinh;
    private JTextField txtCK;
    private JTextField txtTenHocPhan;

    private JButton btnTinh;
    private JButton btnNhap;

    private JTable tblDiem;

    // Số học phần
    private int n = 0;

    // Số học phần đã nhập
    private int dem = 0;


    // ================= CONSTRUCTOR =================

    public XepLoai() {

        // Do IntelliJ GUI Designer sinh ra


        setContentPane(mainPanel);

        setTitle("Xếp loại học phần");

        setSize(1100, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(new Object[]{
                "stt",
                "Họ tên",
                "Ngày sinh",
                "Tên học phần",
                "CC",
                "GK",
                "CK",
                "Tổng kết",
                "Xếp loại"
        });

        tblDiem.setModel(model);

        tblDiem.setRowHeight(25);

        tblDiem.setShowGrid(true);


        // ================= BUTTON =================

        btnNhap.addActionListener(e -> nhapVaoBang());

        btnTinh.addActionListener(e -> tinhXepLoai());
    }


    // =====================================================
    // NHẬP HỌC PHẦN VÀO BẢNG
    // =====================================================

    private void nhapVaoBang() {

        // ==========================================
        // BƯỚC 1: LẤY SỐ HỌC PHẦN
        // ==========================================

        if (n == 0) {

            String soHPText =
                    txtSoHocPhan.getText().trim();

            if (soHPText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Vui lòng nhập số học phần!"
                );

                txtSoHocPhan.requestFocus();

                return;
            }

            try {

                n = Integer.parseInt(soHPText);

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Số học phần phải là số nguyên!"
                );

                txtSoHocPhan.requestFocus();

                return;
            }


            if (n <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Số học phần phải lớn hơn 0!"
                );

                n = 0;

                txtSoHocPhan.requestFocus();

                return;
            }
        }


        // ==========================================
        // BƯỚC 2: KIỂM TRA ĐÃ NHẬP ĐỦ n CHƯA
        // ==========================================

        if (dem >= n) {

            JOptionPane.showMessageDialog(
                    this,
                    "Đã nhập đủ " + n + " học phần!"
            );

            return;
        }


        // ==========================================
        // BƯỚC 3: LẤY THÔNG TIN
        // ==========================================

        String hoTen =
                txtHoTen.getText().trim();

        String ngaySinh =
                txtNgaySinh.getText().trim();

        String tenHocPhan =
                txtTenHocPhan.getText().trim();


        // ==========================================
        // KIỂM TRA THÔNG TIN
        // ==========================================

        if (hoTen.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập họ tên!"
            );

            txtHoTen.requestFocus();

            return;
        }

        if (ngaySinh.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập ngày sinh!"
            );

            txtNgaySinh.requestFocus();

            return;
        }

        if (tenHocPhan.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập tên học phần!"
            );

            txtTenHocPhan.requestFocus();

            return;
        }


        // ==========================================
        // BƯỚC 4: NHẬP ĐIỂM CC
        // ==========================================

        double cc;

        try {

            cc = Double.parseDouble(
                    txtCC.getText().trim()
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Điểm CC phải là số!"
            );

            txtCC.requestFocus();

            return;
        }


        // ==========================================
        // BƯỚC 5: NHẬP ĐIỂM GK
        // ==========================================

        double gk;

        try {

            gk = Double.parseDouble(
                    txtGK.getText().trim()
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Điểm GK phải là số!"
            );

            txtGK.requestFocus();

            return;
        }


        // ==========================================
        // BƯỚC 6: NHẬP ĐIỂM CK
        // ==========================================

        double ck;

        try {

            ck = Double.parseDouble(
                    txtCK.getText().trim()
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Điểm CK phải là số!"
            );

            txtCK.requestFocus();

            return;
        }


        // ==========================================
        // BƯỚC 7: KIỂM TRA ĐIỂM
        // ==========================================

        if (cc < 0 || cc > 10) {

            JOptionPane.showMessageDialog(
                    this,
                    "Điểm CC phải từ 0 đến 10!"
            );

            txtCC.requestFocus();

            return;
        }

        if (gk < 0 || gk > 10) {

            JOptionPane.showMessageDialog(
                    this,
                    "Điểm GK phải từ 0 đến 10!"
            );

            txtGK.requestFocus();

            return;
        }

        if (ck < 0 || ck > 10) {

            JOptionPane.showMessageDialog(
                    this,
                    "Điểm CK phải từ 0 đến 10!"
            );

            txtCK.requestFocus();

            return;
        }


        // ==========================================
        // BƯỚC 8: TÍNH ĐIỂM HỌC PHẦN
        // ==========================================

        double tongKet =
                cc * 0.1
                        + gk * 0.3
                        + ck * 0.6;


        // ==========================================
        // BƯỚC 9: XẾP LOẠI
        // ==========================================

        String xepLoai;

        if (tongKet >= 8.5) {

            xepLoai = "A";

        } else if (tongKet >= 7.0) {

            xepLoai = "B";

        } else if (tongKet >= 5.5) {

            xepLoai = "C";

        } else if (tongKet >= 4.0) {

            xepLoai = "D";

        } else {

            xepLoai = "F";
        }


        // ==========================================
        // BƯỚC 10: THÊM VÀO TABLE
        // ==========================================

        DefaultTableModel model =
                (DefaultTableModel) tblDiem.getModel();

        dem++;

        model.addRow(new Object[]{
                dem,
                hoTen,
                ngaySinh,
                tenHocPhan,
                cc,
                gk,
                ck,
                String.format("%.2f", tongKet),
                xepLoai
        });


        // ==========================================
        // THÔNG BÁO
        // ==========================================

        JOptionPane.showMessageDialog(
                this,
                "Đã nhập học phần "
                        + dem
                        + "/"
                        + n
        );


        // ==========================================
        // XÓA DỮ LIỆU CŨ ĐỂ NHẬP HỌC PHẦN TIẾP
        // ==========================================

        txtTenHocPhan.setText("");

        txtCC.setText("");

        txtGK.setText("");

        txtCK.setText("");

        txtTenHocPhan.requestFocus();
    }


    // =====================================================
    // NÚT TÍNH XẾP LOẠI
    // =====================================================

    private void tinhXepLoai() {

        int row =
                tblDiem.getSelectedRow();


        // Chưa chọn dòng

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Hãy chọn một học phần trong bảng!"
            );

            return;
        }


        try {

            double cc =
                    Double.parseDouble(
                            tblDiem
                                    .getValueAt(row, 4)
                                    .toString()
                    );

            double gk =
                    Double.parseDouble(
                            tblDiem
                                    .getValueAt(row, 5)
                                    .toString()
                    );

            double ck =
                    Double.parseDouble(
                            tblDiem
                                    .getValueAt(row, 6)
                                    .toString()
                    );


            double tongKet =
                    cc * 0.1
                            + gk * 0.3
                            + ck * 0.6;


            String xepLoai;

            if (tongKet >= 8.5) {

                xepLoai = "A";

            } else if (tongKet >= 7.0) {

                xepLoai = "B";

            } else if (tongKet >= 5.5) {

                xepLoai = "C";

            } else if (tongKet >= 4.0) {

                xepLoai = "D";

            } else {

                xepLoai = "F";
            }


            // Cập nhật tổng kết

            tblDiem.setValueAt(
                    String.format("%.2f", tongKet),
                    row,
                    7
            );


            // Cập nhật xếp loại

            tblDiem.setValueAt(
                    xepLoai,
                    row,
                    8
            );


            JOptionPane.showMessageDialog(
                    this,
                    "Tổng kết: "
                            + String.format("%.2f", tongKet)
                            + "\nXếp loại: "
                            + xepLoai
            );


        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Không thể tính điểm!"
            );
        }
    }


    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            XepLoai form =
                    new XepLoai();

            form.setVisible(true);
        });
    }


    // =====================================================
    // $$$setupUI$$$
    // =====================================================
    //
    // PHẦN NÀY INTELLIJ GUI DESIGNER TỰ SINH.
    //
    // GIỮ NGUYÊN HÀM $$$setupUI$$$() CỦA BẠN Ở ĐÂY.
    //
    // KHÔNG TỰ VIẾT LẠI.
    //
}