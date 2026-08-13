import javax.swing.*;

public class MainForm {

    private JPanel panel1;
    private JTextField txtSo1;
    private JTextField txtSo2;
    private JButton btnTinhTong;
    private JLabel lblKetQua;

    public MainForm() {

        btnTinhTong.addActionListener(e -> {
            try {
                double so1 = Double.parseDouble(txtSo1.getText());
                double so2 = Double.parseDouble(txtSo2.getText());

                double tong = so1 + so2;

                lblKetQua.setText("Kết quả: " + tong);

            } catch (NumberFormatException ex) {
                lblKetQua.setText("Vui lòng nhập số!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tính tổng 2 số");

        MainForm mainForm = new MainForm();

        frame.setContentPane(mainForm.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}