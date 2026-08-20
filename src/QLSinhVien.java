import javax.swing.*;

public class QLSinhVien {

    private JPanel jpanel1;

    private JTextField textField1; // Mã sinh viên
    private JTextField textField2; // Họ tên
    private JTextField textField3; // Tuổi
    private JTextField textField4; // Điểm

    private JButton thêmButton;
    private JButton làmMớiButton;
    private JButton xóaButton;
    private JButton sửaButton;

    private JTextArea textArea1;


    private StringBuilder danhSach = new StringBuilder();

    public QLSinhVien() {
        thêmButton.addActionListener(e -> {

            String maSV = textField1.getText().trim();
            String hoTen = textField2.getText().trim();
            String tuoi = textField3.getText().trim();
            String diem = textField4.getText().trim();

            if (maSV.isEmpty() || hoTen.isEmpty()
                    || tuoi.isEmpty() || diem.isEmpty()) {

                JOptionPane.showMessageDialog(
                        jpanel1,
                        "Vui lòng nhập đầy đủ thông tin!"
                );

                return;
            }

            try {

                int tuoiSV = Integer.parseInt(tuoi);
                double diemSV = Double.parseDouble(diem);

                if (tuoiSV <= 0) {
                    JOptionPane.showMessageDialog(
                            jpanel1,
                            "Tuổi phải lớn hơn 0!"
                    );
                    return;
                }

                if (diemSV < 0 || diemSV > 10) {
                    JOptionPane.showMessageDialog(
                            jpanel1,
                            "Điểm phải từ 0 đến 10!"
                    );
                    return;
                }

                danhSach.append(
                        "Mã SV: " + maSV +
                                " | Họ tên: " + hoTen +
                                " | Tuổi: " + tuoiSV +
                                " | Điểm: " + diemSV +
                                "\n"
                );

                hienThiDanhSach();

                xoaTrang();

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        jpanel1,
                        "Tuổi phải là số nguyên và điểm phải là số!"
                );
            }
        });
        làmMớiButton.addActionListener(e -> {
            xoaTrang();
        });
        xóaButton.addActionListener(e -> {

            String maSV = textField1.getText().trim();

            if (maSV.isEmpty()) {
                JOptionPane.showMessageDialog(
                        jpanel1,
                        "Vui lòng nhập mã sinh viên cần xóa!"
                );
                return;
            }

            String[] danhSachSV = danhSach.toString().split("\n");

            StringBuilder moi = new StringBuilder();

            boolean timThay = false;

            for (String sv : danhSachSV) {

                if (!sv.isEmpty()) {

                    if (sv.startsWith("Mã SV: " + maSV + " |")) {
                        timThay = true;
                    } else {
                        moi.append(sv).append("\n");
                    }
                }
            }

            if (timThay) {

                danhSach = moi;

                hienThiDanhSach();
                xoaTrang();

                JOptionPane.showMessageDialog(
                        jpanel1,
                        "Xóa sinh viên thành công!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        jpanel1,
                        "Không tìm thấy sinh viên có mã: " + maSV
                );
            }
        });
        sửaButton.addActionListener(e -> {

            String maSV = textField1.getText().trim();
            String hoTen = textField2.getText().trim();
            String tuoi = textField3.getText().trim();
            String diem = textField4.getText().trim();

            if (maSV.isEmpty() || hoTen.isEmpty()
                    || tuoi.isEmpty() || diem.isEmpty()) {

                JOptionPane.showMessageDialog(
                        jpanel1,
                        "Vui lòng nhập đầy đủ thông tin!"
                );

                return;
            }

            try {

                int tuoiSV = Integer.parseInt(tuoi);
                double diemSV = Double.parseDouble(diem);

                if (tuoiSV <= 0 || diemSV < 0 || diemSV > 10) {

                    JOptionPane.showMessageDialog(
                            jpanel1,
                            "Tuổi hoặc điểm không hợp lệ!"
                    );

                    return;
                }

                String[] danhSachSV = danhSach.toString().split("\n");

                StringBuilder moi = new StringBuilder();

                boolean timThay = false;

                for (String sv : danhSachSV) {

                    if (!sv.isEmpty()) {

                        if (sv.startsWith("Mã SV: " + maSV + " |")) {

                            moi.append(
                                    "Mã SV: " + maSV +
                                            " | Họ tên: " + hoTen +
                                            " | Tuổi: " + tuoiSV +
                                            " | Điểm: " + diemSV +
                                            "\n"
                            );

                            timThay = true;

                        } else {

                            moi.append(sv).append("\n");
                        }
                    }
                }

                if (timThay) {

                    danhSach = moi;

                    hienThiDanhSach();
                    xoaTrang();

                    JOptionPane.showMessageDialog(
                            jpanel1,
                            "Sửa sinh viên thành công!"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            jpanel1,
                            "Không tìm thấy sinh viên có mã: " + maSV
                    );
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        jpanel1,
                        "Tuổi phải là số nguyên và điểm phải là số!"
                );
            }
        });
    }


    private void hienThiDanhSach() {

        textArea1.setText("");

        textArea1.append(
                "MÃ SV\tHỌ TÊN\tTUỔI\tĐIỂM\n"
        );

        textArea1.append(
                "----------------------------------------------------------\n"
        );

        String[] danhSachSV = danhSach.toString().split("\n");

        for (String sv : danhSachSV) {

            if (!sv.isEmpty()) {
                textArea1.append(sv + "\n");
            }
        }
    }
    private void xoaTrang() {

        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");

        textField1.requestFocus();
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("Quản lý sinh viên");

        QLSinhVien qlSinhVien = new QLSinhVien();

        frame.setContentPane(qlSinhVien.jpanel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700, 500);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}