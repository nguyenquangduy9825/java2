import javax.swing.*;

public class Dangnhap {

    private JPanel panel1;
    private JTextField txtTaiKhoan;
    private JPasswordField txtMatKhau;
    private JButton btnDangNhap;
    private JCheckBox chkGhiNho;
    private JButton btnThoat;

    public Dangnhap() {
        btnDangNhap.addActionListener(e -> {

            String taiKhoan = txtTaiKhoan.getText().trim();
            String matKhau = new String(txtMatKhau.getPassword());
            if (taiKhoan.isEmpty() || matKhau.isEmpty()) {

                JOptionPane.showMessageDialog(
                        panel1,
                        "Vui lòng nhập đầy đủ tài khoản và mật khẩu!",
                        "Thông báo",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }
            if (taiKhoan.equals("admin") && matKhau.equals("123456")) {

                if (chkGhiNho.isSelected()) {
                    JOptionPane.showMessageDialog(
                            panel1,
                            "Đăng nhập thành công!\nĐã chọn ghi nhớ tài khoản.",
                            "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            panel1,
                            "Đăng nhập thành công!",
                            "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

            } else {

                JOptionPane.showMessageDialog(
                        panel1,
                        "Tài khoản hoặc mật khẩu không đúng!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
        btnThoat.addActionListener(e -> {

            int result = JOptionPane.showConfirmDialog(
                    panel1,
                    "Bạn có muốn thoát không?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Đăng nhập");

        Dangnhap dangnhap = new Dangnhap();

        frame.setContentPane(dangnhap.panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}